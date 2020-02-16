package com.capgemini.retailermentenance.controller;

import org.omg.CORBA.UserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.retailermentenance.exception.ProductExceptions;
import com.capgemini.retailermentenance.response.ProductResponse;
import com.capgemini.retailermentenance.response.UserResponse;

@RestControllerAdvice
public class RetailerMentenanceAdviceController {

	@ExceptionHandler(ProductExceptions.class)
	public ProductResponse productException(ProductExceptions e) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setStatusCode(501);
		productResponse.setDescription("Exception");
		productResponse.setMessage(e.getMessage());
		return productResponse;
	}
	
	@ExceptionHandler(UserException.class)
	public UserResponse userException(UserException e) {
		UserResponse userResponse = new UserResponse();
		userResponse.setStatusCode(501);
		userResponse.setDescription("Exception");
		userResponse.setMessage(e.getMessage());
		return userResponse;
	}
	
	

}


//@RestControllerAdvice
//public class AuthenticationControllerAdvice {
//	
//	@ExceptionHandler(ProductException.class)
//	public AuthenticationResponse authException(ProductException e) {
//		AuthenticationResponse response = new AuthenticationResponse();
//		response.setStatusCode(501);
//		response.setDescription("Exception");
//		response.setMessage(e.getMessage());
//		return response;
//	}
//
//}