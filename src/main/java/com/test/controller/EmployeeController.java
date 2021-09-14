package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.DimEmployee;
import com.test.service.EmployeeService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping(value = "/emp/**")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@ResponseBody
	@PostMapping(value = "/createEmployee")
	public int createEmployee(@RequestBody DimEmployee emp) {
		return employeeService.createEmployee(emp);
	}

	@ResponseBody
	@PostMapping(value = "/deleteEmployee")
	public int deleteEmployee(@RequestBody Integer employeeSkey) {
		return employeeService.deleteEmployee(employeeSkey);
	}

	@GetMapping(value = "/getAllEmployee")
	public List<DimEmployee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping(value = "/test")
	public String test() {
		return "working";
	}
}
