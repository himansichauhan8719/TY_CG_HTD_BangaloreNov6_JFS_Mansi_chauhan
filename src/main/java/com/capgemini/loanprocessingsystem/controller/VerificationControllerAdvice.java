package com.capgemini.loanprocessingsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.loanprocessingsystem.dto.VerificationResponse;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@RestControllerAdvice
public class VerificationControllerAdvice {
	@ExceptionHandler(CustomException.class)
	public VerificationResponse handleCustomException(CustomException customException) {
		VerificationResponse verificationResponse = new VerificationResponse();
		verificationResponse.setStatusCode(501);
		verificationResponse.setMessage("Exception");
		verificationResponse.setDescription(customException.getMessage());
		return  verificationResponse;
	}

}
