package test.hrms2.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import test.hrms2.business.abstracts.CandidateService;
import test.hrms2.business.abstracts.MernisDemoService;
import test.hrms2.business.abstracts.VerificationCodeService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.ErrorResult;
import test.hrms2.core.results.Result;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.core.results.SuccessResult;
import test.hrms2.dataAccess.abstracts.CandidateDao;
import test.hrms2.dataAccess.abstracts.UserDao;
import test.hrms2.entities.abstracts.User;
import test.hrms2.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserDao userDao;
	private VerificationCodeService verificationCodeService;
	private MernisDemoService mernisDemoService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao, VerificationCodeService verificationCodeService,
			MernisDemoService mernisDemoService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
		this.mernisDemoService = mernisDemoService;
	}

	@Override
	public DataResult<List<Candidate>> findAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),
				"Is arayanlar basarili bir sekilde listelendi");
	}

	@Override
	public Result add(Candidate candidate) {

		if (Strings.isNullOrEmpty(candidate.getFirstname())) {
			return new ErrorResult("Lütfen isminizi bos gecmeyiniz");
		}

		else if (Strings.isNullOrEmpty(candidate.getLastname())) {
			return new ErrorResult("Lütfen soyisminizi bos gecmeyiniz");
		}

		else if (candidate.getBirthDate() == null) {
			return new ErrorResult("Lütfen dogum yilini bos gecmeyiniz");
		}

		else if (candidate.getEmail() == null) {
			return new ErrorResult("Lütfen email adresinizi bos gecmeyiniz");
		}

		else if (candidate.getPassword().length() <= 6) {
			return new ErrorResult("Lütfen sifrenizi 6 karakterden az girmeyiniz");
		}

		else if (!mernisDemoService.isValidNationolityIdentity(candidate.getIdentificationNumber())) {

			return new ErrorResult("TC Kimlik dogrulamasi yapilamadi");
		}

		else if (isEmailValid(candidate.getEmail())) {
			
			candidate.setMailVerify(false);
			User savedUser = this.userDao.save(candidate);

			this.verificationCodeService.createActivationCode(savedUser);
			this.candidateDao.save(candidate);
			return new SuccessResult(candidate.getEmail() + " Adresine doğrulama kodu gönderildi");
		} else {

			return new ErrorResult("Kullanıcı bilgileri hatalı");
		}
	}

	/*
	 * @Override public DataResult<User> getByEmail(String email) { return new
	 * SuccessDataResult<User>(this.userDao.findByEmail(email), "Listelendi"); //
	 * User alani Candidate // olarak degistirilecek }
	 */

	/*
	 * @Override public DataResult<Candidate> getByIdentifacationNumber(String
	 * identificationNumber) { return new
	 * SuccessDataResult<Candidate>(this.candidateDao.findByIdentificationNumber(
	 * identificationNumber), "Listelendi"); }
	 */

	@Override
	public DataResult<List<Candidate>> findAllByEmail(String email) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAllByEmail(email), "Listelendi");
	}

	@Override
	public DataResult<List<Candidate>> findAllByIdentificationNumber(String identificationNumber) {
		return new SuccessDataResult<List<Candidate>>(
				this.candidateDao.findAllByIdentificationNumber(identificationNumber), "Listelendi");
	}

	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}
}
