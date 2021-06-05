package test.hrms2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.hrms2.entities.concretes.Employer;
@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer>{

	// Email Numaralari listelenecek
	 //List<Employer> findAllByEmail(String email);
}
