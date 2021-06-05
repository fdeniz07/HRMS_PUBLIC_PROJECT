package test.hrms2.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.hrms2.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> findByIsActive(boolean isActive);

	List<JobAdvertisement> findAll();

	//List<JobAdvertisement> findByIsActiveAndEmployer_Id(boolean isActive, int employerId);

	//List<JobAdvertisement> findByIsActiveAndEmployer_CompanyNameContainsIgnoreCase(boolean isActive,String companyName); // ContainsIgnoreCase : key insencitive

	List<JobAdvertisement> findByIsActiveIsTrueOrderByCreatedDateAsc();

	// Ilan id sine göre sorgu
	//JobAdvertisement findById(int id);

}
