package test.hrms2.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.hrms2.entities.concretes.JobPosition;
@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

	//Tüm Is Positionlari listelenecek
	List<JobPosition> findAllByPosition(String position);
	boolean existsJobPositionByPositionIgnoreCase(String position);
}
