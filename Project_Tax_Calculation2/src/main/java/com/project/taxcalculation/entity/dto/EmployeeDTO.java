package com.project.taxcalculation.entity.dto;

import java.util.Date;

import com.project.taxcalculation.entity.Employee;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeDTO {
	
	@NotBlank(message="Employee FirstName should not be Blank")
	@NotEmpty(message="Employee FirstName should not be Empty")
	private String firstName;
	
	@NotBlank(message="Employee FirstName should not be Blank")
	@NotEmpty(message="Employee LastName should not be Empty")
	private String lastName;
	
	@Email
	@NotBlank(message="Employee Mail ID should not be Blank")
	private String email;
	
	@Pattern(regexp="^\\d{10}$",message="Invalid phone Number")
	private String phoneNumber;
	
	
	
	private Date doj;
	
	
	private float salary_permonth;
	
	
	public static Employee addEmployee(EmployeeDTO employeedto) {
		
		Employee employee = new Employee();
		
		employee.setFirstName(employeedto.getFirstName());
		employee.setLastName(employeedto.getLastName());
		employee.setEmail(employeedto.getEmail());
		employee.setPhoneNumber(employeedto.getPhoneNumber());
		employee.setDoj(employeedto.getDoj());
		employee.setSalary_permonth(employeedto.getSalary_permonth());
		return employee;
		
		
	}

}
