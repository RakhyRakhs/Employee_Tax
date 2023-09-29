package com.project.taxcalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.taxcalculation.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	
	Employee findByEmployeeId(int employeeId);
	
	

}
