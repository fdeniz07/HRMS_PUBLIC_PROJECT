package test.hrms2.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import test.hrms2.business.abstracts.ConfirmByEmployeeService;
import test.hrms2.business.abstracts.EmployerService;
import test.hrms2.business.abstracts.VerificationCodeService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.ErrorDataResult;
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


	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao,
			VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
		
	}

	@Override
	public DataResult<List<Employer>> findAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
				"Is verenler basarili bir sekilde listelendi");
	}

	@Override
	public DataResult<Employer> add(Employer employer) {

		if (Strings.isNullOrEmpty(employer.getCompanyName())) {
			return new ErrorDataResult<Employer>("Lütfen firma isminizi bos gecmeyiniz");
		}

		else if (Strings.isNullOrEmpty(employer.getWebAddress())) {
			return new ErrorDataResult<Employer>("Lütfen web adresinizi bos gecmeyiniz");
		}

		else if (Strings.isNullOrEmpty(employer.getPhoneNumber())) {
			return new ErrorDataResult<Employer>("Lütfen telefon numaranizi bos gecmeyiniz");
		}

		else if (Strings.isNullOrEmpty(employer.getEmail())) {
			return new ErrorDataResult<Employer>("Lütfen email adresinizi bos gecmeyiniz");
		}

		else if (Strings.isNullOrEmpty(employer.getPassword()) && employer.getPassword().length() <= 6) {
			return new ErrorDataResult<Employer>("Lütfen sifrenizi 6 karakterden az girmeyiniz");
		}

		else if (!EmployerValidator.EmployerDomainCheck(employer)) {

			return new ErrorDataResult<Employer>("Domain dogrulamasi yapilamadi");
		}

		else if (isEmailValid(employer.getEmail())) {
			
			/*
			 * System.out.println(employer.getCompanyName()+" "+employer.getId()+" "+
			 * employer.getConfirmByEmployees());
			 */
			employer.setMailVerify(false);
			
			User savedUser = this.userDao.save(employer);

			this.verificationCodeService.createActivationCode(savedUser);
			ConfirmByEmployee confirmByEmployee = new ConfirmByEmployee();
					
			
			confirmByEmployee.setConfirm(true);
			
			return new SuccessDataResult<Employer>(this.employerDao.save(employer),employer.getEmail() + " Adresine doğrulama kodu gönderildi");
		} else {

			return new ErrorDataResult<Employer>("Kullanıcı bilgileri hatalı");
		}

	}

	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

}
