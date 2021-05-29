package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.abstracts.User;
import test.hrms2.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	VerificationCode findByCode(String code);
	DataResult<List<VerificationCode>> findAllByCode();
	String createActivationCode(User user);
	Result activateUser(String activationCode);
	
}
