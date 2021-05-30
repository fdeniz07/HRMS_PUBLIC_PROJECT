package test.hrms2.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.ConfirmByEmployeeService;
import test.hrms2.core.results.Result;
import test.hrms2.core.results.SuccessResult;
import test.hrms2.dataAccess.abstracts.ConfirmByEmployeeDao;
import test.hrms2.entities.concretes.ConfirmByEmployee;

@Service
public class ConfirmByEmployeeManager implements ConfirmByEmployeeService {

	ConfirmByEmployeeDao confirmByEmployeeDao;

	@Autowired
	public ConfirmByEmployeeManager(ConfirmByEmployeeDao confirmByEmployeeDao) {
		super();
		this.confirmByEmployeeDao = confirmByEmployeeDao;
	}

	@Override
	public Result add(ConfirmByEmployee confirmByEmployee) {
		this.confirmByEmployeeDao.save(confirmByEmployee);
		return new SuccessResult("Basarili kayit");
	}

}
