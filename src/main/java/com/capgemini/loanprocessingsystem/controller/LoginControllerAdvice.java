package com.capgemini.loanprocessingsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.loanprocessingsystem.dto.LoginResponse;

import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@RestControllerAdvice
public class LoginControllerAdvice {
	@ExceptionHandler(CustomException.class)
	public LoginResponse handleLoginException(CustomException e) {
		LoginResponse response = new LoginResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
}
