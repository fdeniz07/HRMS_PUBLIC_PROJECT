package test.hrms2.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.hrms2.entities.concretes.Candidate;
@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer>{

		
	List<Candidate> findAllByEmail(String email);
	
	List<Candidate> findAllByIdentificationNumber(String identificationNumber);
	
	boolean existsCandidateByIdentificationNumber(String identificationNumber);
	
	boolean existsCandidateByEmail(String email);
	
}
