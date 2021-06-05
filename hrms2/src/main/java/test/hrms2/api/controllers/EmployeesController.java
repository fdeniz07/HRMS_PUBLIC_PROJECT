package test.hrms2.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.hrms2.business.abstracts.EmployeeService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.Result;
import test.hrms2.entities.concretes.Employee;

@RestController
@RequestMapping("/api/emplooyes")
public class EmployeesController {

	EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> findAll() {
		return employeeService.findAll();
	}

	@PostMapping("/add")
	public Result Add(@RequestBody Employee employee) {
		return employeeService.add(employee);
	}

	@PostMapping("/delete")
	public Result Delete(@RequestBody @Valid int id) {
		return employeeService.delete(id);
	}

	@PostMapping("/update")
	public Result Update(@RequestBody @Valid Employee employee) {
		return employeeService.update(employee);
	}
	
}
