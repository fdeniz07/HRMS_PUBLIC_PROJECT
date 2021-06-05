package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> findAll();
	//DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_Id(boolean isActive,int employerId);
	//DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyNameContainsIgnoreCase(boolean isActive,String companyName);
	DataResult<List<JobAdvertisement>> findByIsActiveIsTrueOrderByCreatedDateAsc();
	
	Result add(JobAdvertisement jobAdvertisement); 
}
