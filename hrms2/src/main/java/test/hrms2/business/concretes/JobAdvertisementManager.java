package test.hrms2.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.JobAdvertisementService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.dataAccess.abstracts.JobAdvertisementDao;
import test.hrms2.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAll() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
				"Tüm is ilanlari listelendi");
	}

	/*
	 * @Override public DataResult<List<JobAdvertisement>>
	 * findByIsActiveAndEmployer_Id(boolean isActive, int employerId) {
	 * 
	 * return new SuccessDataResult<List<JobAdvertisement>>(
	 * this.jobAdvertisementDao.findByIsActiveAndEmployer_Id(isActive, employerId),
	 * "Aktiv is ilanlari listelendi"); }
	 */

	/*
	 * @Override public DataResult<List<JobAdvertisement>>
	 * findByIsActiveAndEmployer_CompanyNameContainsIgnoreCase(boolean isActive,
	 * String companyName) {
	 * 
	 * return new SuccessDataResult<List<JobAdvertisement>>(
	 * this.jobAdvertisementDao.
	 * findByIsActiveAndEmployer_CompanyNameContainsIgnoreCase(isActive,
	 * companyName), "Firma adina göre aktif is ilanlari listelenmistir"); }
	 */

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveIsTrueOrderByCreatedDateAsc() {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByIsActiveIsTrueOrderByCreatedDateAsc(),
				"Tarihe göre is ilanlari listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {

		return null;
	}

}
