package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.JobPosition;

public interface JobPositionService {
	
	Result add(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> findAll();
	
	DataResult<JobPosition> find(int id);
	
	Result delete(int id);
	
	Result update(JobPosition jobPosition);
	
	boolean existsJobPositionByPosition(String position);

}
