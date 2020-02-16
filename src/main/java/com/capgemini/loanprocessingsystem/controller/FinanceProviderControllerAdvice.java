package com.capgemini.loanprocessingsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.loanprocessingsystem.dto.FinanceProviderResponce;

import com.capgemini.loanprocessingsystem.exceptions.CustomException;

public class FinanceProviderControllerAdvice {
	@ExceptionHandler(CustomException.class)
	public FinanceProviderResponce handleCustomException(CustomException customException) {
		FinanceProviderResponce financeProviderResponce = new FinanceProviderResponce();
		financeProviderResponce.setStatusCode(501);
		financeProviderResponce.setMessage("Exception");
		financeProviderResponce.setDescription(customException.getMessage());
		return  financeProviderResponce;
	}

}
