package test.hrms2.business.concretes;

import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.VerificationCodeService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.core.results.SuccessResult;
import test.hrms2.dataAccess.abstracts.UserDao;
import test.hrms2.dataAccess.abstracts.VerificationCodeDao;
import test.hrms2.entities.abstracts.User;
import test.hrms2.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	VerificationCodeDao verificationCodeDao;
	UserDao userDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao, UserDao userDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<VerificationCode>> findAllByCode() {

		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll(),
				"Basariyla listelendi");
	}

	// User kayit sirasinda Aktivasyon Kodu cagrilir
	String generatedCode = "";

	@Override
	public String createActivationCode(User user) {

		for (int i = 0; i == 0; i = 0) {
			generatedCode = randomCodeGenarator(20); // Random kod olustur
			if (findByCode(generatedCode) == null) {
				break;
			}
		}
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setId(user.getId());
		verificationCode.setCode(generatedCode);
		verificationCodeDao.save(verificationCode);
		return generatedCode;
	}

	@Override
	public Result activateUser(String activationCode) {
		
		VerificationCode verificationCode = verificationCodeDao.findByCode(activationCode);
		verificationCode.setVerified(true);
		verificationCodeDao.save(verificationCode);
		return new SuccessResult("Kullanici aktivasyonu gerceklesti");
		//userDao.save(verificationCode);
		//User user = userDao.getOne(verificationCodeDao.findByCode(activationCode).getId());
		//user.setMailVerify(true);
		
	}

	@Override
	public VerificationCode findByCode(String code) {

		return this.verificationCodeDao.findByCode(code);
	}

	private final String whatsUp = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private SecureRandom mixer = new SecureRandom();

	private String randomCodeGenarator(int lenght) {
		StringBuilder randomValueConstructor = new StringBuilder(lenght);
		for (int i = 0; i < lenght; i++) {
			randomValueConstructor.append(whatsUp.charAt(mixer.nextInt(whatsUp.length())));
		}
		return randomValueConstructor.toString();
	}

}
