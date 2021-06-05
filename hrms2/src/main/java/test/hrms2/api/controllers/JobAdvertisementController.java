package test.hrms2.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.hrms2.business.abstracts.JobAdvertisementService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
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

	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("getallactivated")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		return this.jobAdvertisementService.findByIsActiveTrue();
	}
	
	@GetMapping("getallactivatedorderbycreateddateasc")
	public DataResult<List<JobAdvertisement>> findByIsActiveIsTrueOrderByCreatedDateAsc() {
		return this.jobAdvertisementService.findByIsActiveIsTrueOrderByCreatedDateAsc();
	}	

	@GetMapping("getallactivatedorderbydeadlineasc")
	public DataResult<List<JobAdvertisement>> findByIsActiveIsTrueOrderByDeadlineAsc() {
		return this.jobAdvertisementService.findByIsActiveIsTrueOrderByDeadlineAsc();
	}		
	
	@GetMapping("getallactivatedandemployerid")
	public DataResult<List<JobAdvertisement>> findByIsActiveIsTrueAndEmployerId(@RequestParam(name = "id") Integer id) {
		return this.jobAdvertisementService.findByIsActiveIsTrueAndEmployerId(id);
	}
	
	@GetMapping("activatejobadvertisement")
	public Result activateJobAdvertisement(Integer id) {
		return this.jobAdvertisementService.activateJobAdvertisement(id);
	}
	
	@GetMapping("deactivatejobadvertisement")
	public Result deactivateJobAdvertisement(Integer id) {
		return this.jobAdvertisementService.deactivateJobAdvertisement(id);
	}

	

}
