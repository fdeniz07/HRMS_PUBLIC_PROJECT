package test.hrms2.business.abstracts;

import test.hrms2.entities.abstracts.User;

public interface EmailService {

	void sendEmailVerify(User user, String code);
}
