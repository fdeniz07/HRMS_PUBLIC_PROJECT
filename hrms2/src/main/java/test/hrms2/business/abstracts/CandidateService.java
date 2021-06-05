package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.Candidate;

public interface CandidateService {

	//DataResult<Candidate> findByIdentifacationNumber (String identificationNumber); //Istenilen basvuru yapanin kimlik numarasi
	
	DataResult<Candidate> find(int id); // Id si girilen adayi bul
	
	DataResult<List<Candidate>> findAllByEmail(String email); //Tüm adaylarin mailleri
	
	DataResult<List<Candidate>> findAllByIdentificationNumber(String identificationNumber); //Kimlik numarasina göre tüm is basvurusu yapanlar
		
	DataResult<List<Candidate>> findAll(); //Tüm isbasvurusu yapanlarin listesi
		
	Result add(Candidate candidate); 
	
	Result delete(int id);
	
	Result update(Candidate candidate);
	
	boolean existsCandidateByIdentificationNumber(String identificationNumber);
	
	boolean existsCandidateByEmail(String email);
	
	

}
