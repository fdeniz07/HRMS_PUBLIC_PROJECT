package test.hrms2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.hrms2.entities.abstracts.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email); // Verilen email kaydini getirir
	
	//Tüm email adreslerini listeler
	//List<User> findAllByEmail(String email); 

}
