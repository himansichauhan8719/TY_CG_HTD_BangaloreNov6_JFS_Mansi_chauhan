package com.capgemini.loanprocessingsystem.controller;




import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.loanprocessingsystem.dto.StatusResponse;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;


@RestControllerAdvice
public class StatusControllerAdvice {
	@ExceptionHandler(CustomException.class)
	public StatusResponse handleCustomException(CustomException customException) {
		StatusResponse statusResponse = new StatusResponse();
		statusResponse.setStatusCode(501);
		statusResponse.setMessage("Exception");
		statusResponse.setDescription(customException.getMessage());
		return  statusResponse;
	}
}
