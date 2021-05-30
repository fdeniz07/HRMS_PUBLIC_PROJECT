package test.hrms2.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.hrms2.business.abstracts.EmployerService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	
	  @GetMapping("/getall") 
	  public DataResult<List<Employer>> getAll(){ 
		  return employerService.findAll(); 
	  }
	  
	  @PostMapping("/add") 
	  public Result Add(@RequestBody Employer employer){
	  return employerService.add(employer); 
	  }	
	
	
}
