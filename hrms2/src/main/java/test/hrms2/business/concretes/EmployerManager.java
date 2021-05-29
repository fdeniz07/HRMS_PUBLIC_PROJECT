package test.hrms2.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import test.hrms2.business.abstracts.EmployerService;
import test.hrms2.business.abstracts.VerificationCodeService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.ErrorResult;
import test.hrms2.core.results.Result;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.core.results.SuccessResult;
import test.hrms2.core.validations.EmployerValidator;
import test.hrms2.dataAccess.abstracts.EmployerDao;
import test.hrms2.dataAccess.abstracts.UserDao;
import test.hrms2.entities.abstracts.User;
import test.hrms2.entities.concretes.ConfirmByEmployee;
import test.hrms2.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;
	private VerificationCodeService verificationCodeService;
	private ConfirmByEmployee confirmByEmployee;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
				"Is verenler basarili bir sekilde listelendi");
	}

	@Override
	public Result add(Employer employer) {

		if (Strings.isNullOrEmpty(employer.getCompanyName())) {
			return new ErrorResult("Lütfen firma isminizi bos gecmeyiniz");
		}

		else if (Strings.isNullOrEmpty(employer.getWebAddress())) {
			return new ErrorResult("Lütfen web adresinizi bos gecmeyiniz");
		}

		else if (Strings.isNullOrEmpty(employer.getPhoneNumber())) {
			return new ErrorResult("Lütfen telefon numaranizi bos gecmeyiniz");
		}

		else if (Strings.isNullOrEmpty(employer.getEmail())) {
			return new ErrorResult("Lütfen email adresinizi bos gecmeyiniz");
		}

		else if (Strings.isNullOrEmpty(employer.getPassword()) && employer.getPassword().length() <= 6) {
			return new ErrorResult("Lütfen sifrenizi 6 karakterden az girmeyiniz");
		}

		else if (!EmployerValidator.EmployerDomainCheck(employer)) {

			return new ErrorResult("Domain dogrulamasi yapilamadi");
		}

		else if (isEmailValid(employer.getEmail())) {
			
			employer.setMailVerify(false);
			User savedUser = this.userDao.save(employer);

			this.verificationCodeService.createActivationCode(savedUser);
			this.employerDao.save(employer);
			
			return new SuccessResult(employer.getEmail() + " Adresine doğrulama kodu gönderildi");
		} else {

			return new ErrorResult("Kullanıcı bilgileri hatalı");
		}
//confirmByEmployee.setConfirm(true);

	}

	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

}
