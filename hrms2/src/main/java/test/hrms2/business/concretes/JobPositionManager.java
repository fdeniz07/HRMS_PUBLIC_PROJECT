package test.hrms2.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.JobPositionService;
import test.hrms2.core.results.DataResult;
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
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),
				"Is pozisyonlari basarili bir sekilde listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		jobPositionDao.save(jobPosition);
		return new SuccessResult("Yeni is pozisyonun basarili bir sekilde eklendi");
	}

	@Override
	public DataResult<List<JobPosition>> findAllByPosition(String position) {
		// TODO Auto-generated method stub
		return null;
	}

}
