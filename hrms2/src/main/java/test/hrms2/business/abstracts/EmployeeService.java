package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();
	Result add(Employee employee);
}
