package com.cpg.springrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cpg.springrest.dao.EmployeeResponce;
import com.cpg.springrest.exception.EmployeeException;

@RestControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler(EmployeeException.class)
	
	public EmployeeResponce handleEmployeeException(EmployeeException e) {
		EmployeeResponce responce=new EmployeeResponce();
		responce.setStatusCode(501);
		responce.setMessage("Exception");
		responce.setDiscription(e.getMessage());
		return responce;
	}
	

}
