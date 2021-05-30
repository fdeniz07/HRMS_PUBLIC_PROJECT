package test.hrms2.business.abstracts;

import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.ConfirmByEmployee;

public interface ConfirmByEmployeeService {

	Result add(ConfirmByEmployee confirmByEmployee);
}
