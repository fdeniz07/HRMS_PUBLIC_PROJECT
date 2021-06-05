package test.hrms2.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.hrms2.entities.concretes.VerificationCode;
@Repository
public interface VerificationCodeDao extends JpaRepository<VerificationCode,Integer> {

	VerificationCode findByCode(String code);
	
	//Tüm dogrulama kodlari listelenir
	List<VerificationCode> findAllByCode(String code);
}
