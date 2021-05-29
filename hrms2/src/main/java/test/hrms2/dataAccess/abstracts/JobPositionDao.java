package test.hrms2.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.hrms2.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

	//Tüm Is Positionlari listelenecek
	List<JobPosition> findAllByPosition(String position);
}
