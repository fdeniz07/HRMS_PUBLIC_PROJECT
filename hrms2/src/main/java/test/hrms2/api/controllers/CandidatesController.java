package test.hrms2.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.hrms2.business.abstracts.CandidateService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return candidateService.findAll();
	}

	@PostMapping("/add")
	public Result Add(@RequestBody Candidate candidate) {
		return candidateService.add(candidate);
	}

	@PostMapping("/delete")
	public Result Delete(@RequestBody @Valid int id) {
		return candidateService.delete(id);
	}

	@PostMapping("/update")
	public Result Update(@RequestBody @Valid Candidate candidate) {
		return candidateService.update(candidate);
	}
}
