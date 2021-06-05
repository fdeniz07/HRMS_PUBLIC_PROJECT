package test.hrms2.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.JobAdvertisementService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.core.results.SuccessResult;
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

	//İSTERLER
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Yeni iş ilanı başarıyla eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue(),"Aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveIsTrueOrderByCreatedDateAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveIsTrueOrderByCreatedDateAsc(),"Aktif iş ilanları A'dan Z'ye listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveIsTrueOrderByDeadlineAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveIsTrueOrderByDeadlineAsc(),"Aktif iş ilanları gecerlilik süresine göre A'dan Z'ye listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveIsTrueAndEmployerId(Integer id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveIsTrueAndEmployerId(id),"Aktif iş ilanları Isverene göre listelendi");
	}

	@Override
	public Result activateJobAdvertisement(Integer id) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id).get();
		jobAdvertisement.setIsActive(true);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı başarıyla aktif edildi");
	}

	@Override
	public Result deactivateJobAdvertisement(Integer id) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id).get();
		jobAdvertisement.setIsActive(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı başarıyla pasif edildi");
	}


	




	
	
	//İSTER DIŞI SORGULAR
	



}
