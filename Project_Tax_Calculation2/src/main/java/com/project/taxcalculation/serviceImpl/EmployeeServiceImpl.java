package com.project.taxcalculation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.taxcalculation.entity.Employee;
import com.project.taxcalculation.entity.dto.EmployeeDTO;
import com.project.taxcalculation.exception.EmployeeNotFoundException;
import com.project.taxcalculation.repository.EmployeeRepository;
import com.project.taxcalculation.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeerepository;

	@Override
	public Employee saveEmployee(EmployeeDTO employeedto) {

		return employeerepository.save(EmployeeDTO.addEmployee(employeedto));
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeerepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException {

		Employee employee = employeerepository.findByEmployeeId(employeeId);

		if (employee != null) {
			return employee;
		} else {
			throw new EmployeeNotFoundException("Employee unable to found with given ID :" + employeeId);
		}

	}

	@Override
	public String taxcalculator(int employeeId) throws EmployeeNotFoundException {
		
		float taxcutoff=0,payableamount=0;

		Employee employee = employeerepository.findByEmployeeId(employeeId);

		if (employee != null) {
			
			float salary_month = employee.getSalary_permonth();
			
			float total_salary = salary_month * 12;
			
			System.out.println("Total salary of Given Employee is...." + total_salary);
			
			if(total_salary<=250000) {
				
				 System.out.println("No Tax deductions...bcz total salary is below 250000 so  Total payable salary is ..."+total_salary);
				 
					/*
					 * int eid =employee.getEmployeeId(); String efname =employee.getFirstName();
					 * String elname =employee.getLastName();
					 * 
					 * return eid+" "+efname+" "+elname+" "+total_salary;
					 */
				
			}else if( total_salary >= 250000 && total_salary <=500000) {
				
				float  tax_on_salary = total_salary-250000;

				taxcutoff =5*(tax_on_salary/100);

				payableamount = total_salary-taxcutoff;

				System.out.println("Taxable amount...."+taxcutoff);

				System.out.println("Payable amount after tax deductions....."+payableamount);

			}else if(total_salary>500000 && total_salary<=1000000) {

							
				 taxcutoff =(5*(250000/100))+(10*((total_salary-500000)/100));

				//83333.333---12500+50000=62500----

				
				payableamount = total_salary-taxcutoff;

				System.out.println("Taxable amount...."+taxcutoff);

				System.out.println("Payable amount after tax deductions....."+payableamount);

			}else if(total_salary >1000000){
		
				//104166.66....12500+50000+50000=1137500.
		
			
				taxcutoff =(5*(250000/100))+(10*(500000/100))+(20*((total_salary-1000000)/100));

				payableamount = total_salary-taxcutoff;

				System.out.println("Taxable amount...."+taxcutoff);

				System.out.println("Payable amount after tax deductions....."+payableamount);
			}
			
			int eid =employee.getEmployeeId();
			String efname =employee.getFirstName();
			String elname =employee.getLastName();
			
			return eid+" "+efname+" "+elname+" "+total_salary+" "+taxcutoff+" "+payableamount;
			
			
		} else 
			throw new EmployeeNotFoundException("Employee unable to found with given ID :" + employeeId);
		}

	}


