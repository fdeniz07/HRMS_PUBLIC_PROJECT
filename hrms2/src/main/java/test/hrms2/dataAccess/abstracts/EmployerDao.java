package test.hrms2.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.hrms2.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	// Email Numaralari listelenecek
	 //List<Employer> findAllByEmail(String email);
}
