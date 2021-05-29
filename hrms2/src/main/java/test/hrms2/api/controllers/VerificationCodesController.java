package test.hrms2.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.hrms2.business.abstracts.VerificationCodeService;
import test.hrms2.core.results.Result;

@RestController
@RequestMapping("/api/userverify")
public class VerificationCodesController {

	private VerificationCodeService verificationCodeService;

	@Autowired
	public VerificationCodesController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}
	
	@GetMapping("/active/{code}") //@PathVariable : degeri path'den almak icin 
	public Result activeUser(@PathVariable String code) {
		return verificationCodeService.activateUser(code);
	}
	
}
