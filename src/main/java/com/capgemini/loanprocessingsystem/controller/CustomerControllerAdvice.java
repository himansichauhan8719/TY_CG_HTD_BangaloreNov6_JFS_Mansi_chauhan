package com.capgemini.loanprocessingsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.loanprocessingsystem.dto.CustomerResponse;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@RestControllerAdvice
public class CustomerControllerAdvice {
	@ExceptionHandler(CustomException.class)
	public CustomerResponse handleCustomException(CustomException customException) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setStatusCode(501);
		customerResponse.setMessage("Exception");
		customerResponse.setDescription(customException.getMessage());
		return  customerResponse;
	}

}
