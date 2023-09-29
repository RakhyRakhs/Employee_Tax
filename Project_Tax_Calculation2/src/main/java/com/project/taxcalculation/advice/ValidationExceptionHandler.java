package com.project.taxcalculation.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.taxcalculation.exception.EmployeeNotFoundException;



@RestControllerAdvice
public class ValidationExceptionHandler {
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationErrors(MethodArgumentNotValidException ex){
		
		Map<String,String> errormap= new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			
			errormap.put(error.getField(),error.getDefaultMessage());
		});
		return errormap;
	}
	
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String,String> handleCustomerServiceException(EmployeeNotFoundException ex ){
	Map<String,String>	errormap =new HashMap<>();
	errormap.put("errormessage",ex.getMessage());
	return errormap;
	}

}
