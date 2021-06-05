package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	//İSTERLER
	
	Result add(JobAdvertisement jobAdvertisement); 
		
	DataResult<List<JobAdvertisement>> findByIsActiveTrue(); //Aktif olan is ilanlari
	
	DataResult<List<JobAdvertisement>> findByIsActiveIsTrueOrderByCreatedDateAsc(); //Aktif olan is ilanlarini olusturulma tarihine göre siralama (A-Z)
	
	DataResult<List<JobAdvertisement>> findByIsActiveIsTrueOrderByDeadlineAsc();

	DataResult<List<JobAdvertisement>> findByIsActiveIsTrueAndEmployerId(Integer id);
	
	Result activateJobAdvertisement(Integer id);
	
	Result deactivateJobAdvertisement(Integer id);
	
	
	
	//DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_Id(boolean isActive, int employerId);

	//DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyNameContainsIgnoreCase(boolean isActive,String companyName); // ContainsIgnoreCase : key insencitive

	
	
		
	
	//İSTER DIŞI SORGULAR
	
	
	//boolean existsByIdAndIsActiveIsTrue(int id);
	
	//DataResult<JobAdvertisement> findById(int id);  //is ilanina göre listeleme
	
	//DataResult<List<JobAdvertisement>> findByEmployer_Id(int id); //Ilan veren is verenlerin listesi
	
	//DataResult<List<JobAdvertisement>> findByIsActiveIsTrue(); 	//Durumu aktif olan is ilanlari
	
	//DataResult<List<JobAdvertisement>> findByEmployer_IdAndIsActiveIsTrue(int id); //Is veren Id ye göre aktif is ilanlari
	
	//DataResult<List<JobAdvertisement>> findByEmployer_CompanyNameContainsIgnoreCaseAndIsActiveIsTrue(String companyName); // Firma adina göre aktif is ilanlari (firma adi tam girilmeyebilir)

	//DataResult<JobAdvertisement> findByEmployer_CompanyNameAndJobPosition_PositionContainsIgnoreCase(String companyName,String position); //Firma adi ve pozisyonlara göre listeleme
	
	//DataResult<List<JobAdvertisement>> findByEmployer_CompanyNameContainsIgnoreCase(String companyName); //Firma adina göre ilan arama (firma adi tam girilmeyebilir)
	
	//DataResult<List<JobAdvertisement>> findByOrderByCreatedDateAsc(); //Olusturulma tarihine göre is ilani listeleme (A-Z)

	//DataResult<List<JobAdvertisement>> findByOrderByCreatedDateDesc(); //Olusturulma tarihine göre is ilani listeleme (Z-A)

	//DataResult<List<JobAdvertisement>> findByIsActiveIsTrueOrderByCreatedDateDesc(); //Aktif olan tüm is ilanlarini listeleme (Z-A)

	//JobAdvertisement findByIdAndEmployer_Id(int id, int employerId); //Ilan numarasi ve isveren numarasina göre listeleme
	
}
