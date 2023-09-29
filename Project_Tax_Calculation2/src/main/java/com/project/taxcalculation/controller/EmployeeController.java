package com.project.taxcalculation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.taxcalculation.entity.Employee;
import com.project.taxcalculation.entity.dto.EmployeeDTO;
import com.project.taxcalculation.exception.EmployeeNotFoundException;
import com.project.taxcalculation.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@PostMapping("/store")
	public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeDTO employeedto) {

		return new ResponseEntity<Employee>(employeeservice.saveEmployee(employeedto),HttpStatus.CREATED);

	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeservice.getAllEmployees(),HttpStatus.OK);

	}

	@GetMapping("/fetch/{employeeId}")
	public ResponseEntity<Employee>  getEmployeeById(@PathVariable int  employeeId) throws EmployeeNotFoundException {
		return new ResponseEntity<Employee>(employeeservice.getEmployeeById(employeeId),HttpStatus.OK);
		
	}
	
	@GetMapping("/tax/{employeeId}")
	public ResponseEntity<String>  taxcalculator(@PathVariable int  employeeId) throws EmployeeNotFoundException {
		return new ResponseEntity<String>(employeeservice.taxcalculator(employeeId),HttpStatus.OK);
		
	}
}
