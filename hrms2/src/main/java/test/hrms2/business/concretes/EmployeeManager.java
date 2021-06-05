package test.hrms2.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.EmployeeService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.core.results.SuccessResult;
import test.hrms2.dataAccess.abstracts.EmployeeDao;
import test.hrms2.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> findAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),
				"Sistem personelleri başarıyla listelendi.");
	}

	@Override
	public Result add(Employee employee) {
		
		this.employeeDao.save(employee);
		return new SuccessResult("Sistem personeli başarıyla eklendi.");
	}

	@Override
	public DataResult<Employee> findById(int id) {
		return new SuccessDataResult<Employee>(this.employeeDao.findById(id));
	}

	@Override
	public Result delete(int id) {
		this.employeeDao.deleteById(id);
		return new SuccessResult("iş arayan başarıyla silindi.");
	}

	@Override
	public Result update(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("iş arayan başarıyla güncellendi.");
	}

}
