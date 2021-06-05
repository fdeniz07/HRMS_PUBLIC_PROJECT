package test.hrms2.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.JobPositionService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.ErrorDataResult;
import test.hrms2.core.results.ErrorResult;
import test.hrms2.core.results.Result;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.core.results.SuccessResult;
import test.hrms2.dataAccess.abstracts.JobPositionDao;
import test.hrms2.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> findAll() {
		
		  return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),
		  "İş pozisyonları başarılı bir şekilde listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {

		if (this.jobPositionDao.existsJobPositionByPositionIgnoreCase(jobPosition.getPosition())) {
			return new ErrorResult("Bu isimde bir iş pozisyonu vardır.");
		} else {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Yeni iş pozisyonu başarılı bir şekilde eklendi");
		}
	}

	@Override
	public DataResult<JobPosition> find(int id) {
		if (this.jobPositionDao.findById(id).orElse(null) != null ) {
			return new SuccessDataResult<JobPosition>(
					this.jobPositionDao.findById(id).get(),"Belirtilen iş pozisyonu başarıyla bulundu.");
		} else {
			return new ErrorDataResult<JobPosition>("Belirtilen iş pozisyonu mevcut değildir.");
		}
	}

	@Override
	public Result delete(int id) {
		this.jobPositionDao.deleteById(id);
		return new SuccessResult("İş pozisyonu başarıyla silindi.");
	}

	@Override
	public Result update(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu başarıyla güncellendi.");
	}

	@Override
	public boolean existsJobPositionByPosition(String position) {

		return this.jobPositionDao.existsJobPositionByPositionIgnoreCase(position);
	}

}
