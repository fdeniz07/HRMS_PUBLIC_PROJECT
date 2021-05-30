package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> findAll();
	DataResult<Employer> add(Employer employer);
}
