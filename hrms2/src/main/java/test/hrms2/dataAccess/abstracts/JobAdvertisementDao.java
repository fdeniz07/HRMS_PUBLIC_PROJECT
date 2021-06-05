package test.hrms2.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.hrms2.entities.concretes.JobAdvertisement;
@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	//İSTERLER
		
	List<JobAdvertisement> findByIsActiveTrue(); //Aktif olan is ilanlari
	
	List<JobAdvertisement> findByIsActiveIsTrueOrderByCreatedDateAsc(); //Aktif olan is ilanlarini olusturulma tarihine göre siralama (A-Z)
	
	List<JobAdvertisement> findByIsActiveIsTrueOrderByDeadlineAsc();

	List<JobAdvertisement> findByIsActiveIsTrueAndEmployerId(Integer id);
	

	
	//List<JobAdvertisement> findAll(); //Tüm is ilanlarini listeleme
	
	//List<JobAdvertisement> findByIsActiveAndEmployer_Id(boolean isActive, int employerId);

	//List<JobAdvertisement> findByIsActiveAndEmployer_CompanyNameContainsIgnoreCase(boolean isActive,String companyName); // ContainsIgnoreCase : key insencitive

	
	
	
	//İSTER DIŞI SORGULAR
	
	
	//boolean existsByIdAndIsActiveIsTrue(int id);
	
	//is ilanina göre listeleme
	//JobAdvertisement findById(int id); 
	
	//Ilan veren is verenlerin listesi
	//List<JobAdvertisement> findByEmployer_Id(int id); 
	
	//Durumu aktif olan is ilanlari
	//List<JobAdvertisement> findByIsActiveIsTrue(); 
	
	//Is veren Id ye göre aktif is ilanlari
	//List<JobAdvertisement> findByEmployer_IdAndIsActiveIsTrue(int id); 
	
	// Firma adina göre aktif is ilanlari (firma adi tam girilmeyebilir)
	//List<JobAdvertisement> findByEmployer_CompanyNameContainsIgnoreCaseAndIsActiveIsTrue(String companyName); 

	//Firma adi ve pozisyonlara göre listeleme
	//JobAdvertisement findByEmployer_CompanyNameAndJobPosition_PositionContainsIgnoreCase(String companyName,String position);
	
	//Firma adina göre ilan arama (firma adi tam girilmeyebilir)
	//List<JobAdvertisement> findByEmployer_CompanyNameContainsIgnoreCase(String companyName);
	
	//Olusturulma tarihine göre is ilani listeleme (A-Z)
	//List<JobAdvertisement> findByOrderByCreatedDateAsc();

	//Olusturulma tarihine göre is ilani listeleme (Z-A)
	//List<JobAdvertisement> findByOrderByCreatedDateDesc();

	//Aktif olan tüm is ilanlarini listeleme (Z-A)
	//List<JobAdvertisement> findByIsActiveIsTrueOrderByCreatedDateDesc();

	//Ilan numarasi ve isveren numarasina göre listeleme
	//JobAdvertisement findByIdAndEmployer_Id(int id, int employerId);
	
}
