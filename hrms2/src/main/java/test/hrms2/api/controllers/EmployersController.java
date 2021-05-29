package test.hrms2.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.hrms2.business.abstracts.EmployerService;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	
	
	
	
}
