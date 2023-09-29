package com.project.taxcalculation.service;

import java.util.List;

import com.project.taxcalculation.entity.Employee;
import com.project.taxcalculation.entity.dto.EmployeeDTO;
import com.project.taxcalculation.exception.EmployeeNotFoundException;

public interface EmployeeService {
	
	public Employee saveEmployee(EmployeeDTO employeedto);
	
	public List<Employee>  getAllEmployees();
	
	public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException;
	
	public String taxcalculator(int employeeId) throws EmployeeNotFoundException;

	

}
