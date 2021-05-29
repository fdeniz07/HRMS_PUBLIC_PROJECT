package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.abstracts.User;
import test.hrms2.entities.concretes.Candidate;

public interface CandidateService {

	//DataResult<Candidate> findByIdentifacationNumber (String identificationNumber); //Istenilen basvuru yapanin kimlik numarasi
	
	DataResult<List<Candidate>> findAllByEmail(String email); 
	
	DataResult<List<Candidate>> findAllByIdentificationNumber(String identificationNumber);
		
	DataResult<List<Candidate>> findAll(); //Tüm isbasvurusu yapanlarin listesi
		
	Result add(Candidate candidate); 
	
	//DataResult<User> getByEmail(String email); // istenilen kullaniciya ait mail bilgisi. *ileride User, Candidate olarak degistirilecek*
}
