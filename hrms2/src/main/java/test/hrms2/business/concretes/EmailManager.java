package test.hrms2.business.concretes;

import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.EmailService;
import test.hrms2.entities.abstracts.User;

@Service
public class EmailManager implements EmailService {

	@Override
	public void sendEmailVerify(User user, String code) {
		
		
	}

}
