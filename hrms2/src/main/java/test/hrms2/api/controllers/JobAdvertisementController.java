package test.hrms2.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.hrms2.business.abstracts.JobAdvertisementService;
import test.hrms2.core.results.DataResult;
import test.hrms2.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/advertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return jobAdvertisementService.findAll();
	}

	/*
	 * @GetMapping("/getByIsActiveAndEmployerId") public
	 * DataResult<List<JobAdvertisement>>
	 * getByIsActiveAndEmployer_Id(@RequestParam("isActive") boolean isActive,
	 * 
	 * @RequestParam("employerId") int employerId) { return
	 * jobAdvertisementService.findByIsActiveAndEmployer_Id(isActive, employerId); }
	 */

	/*
	 * @GetMapping("/getByIsActiveAndEmployerCompanyName") public
	 * DataResult<List<JobAdvertisement>>
	 * findByIsActiveAndEmployer_CompanyNameContainsIgnoreCase(
	 * 
	 * @RequestParam("isActive") boolean isActive, @RequestParam("companyName")
	 * String companyName) { return jobAdvertisementService.
	 * findByIsActiveAndEmployer_CompanyNameContainsIgnoreCase(isActive,
	 * companyName); }
	 */

	@GetMapping("/getByIsActiveIsTrueOrderByCreatedDateAsc")
	public DataResult<List<JobAdvertisement>> getByIsActiveIsTrueOrderByCreatedDateAsc() {
		return jobAdvertisementService.findByIsActiveIsTrueOrderByCreatedDateAsc();
	}

}
