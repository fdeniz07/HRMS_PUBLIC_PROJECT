package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> findAll();

	Result add(Employee employee);

	Result delete(int id);

	Result update(Employee employee);

	DataResult<Employee> findById(int id);

}
