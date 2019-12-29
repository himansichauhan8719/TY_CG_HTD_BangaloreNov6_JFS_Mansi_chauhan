package com.capgemini.foresterymanagement.exception;

public class CustomerException extends RuntimeException {
	String message;
	public CustomerException() {

	}
	public CustomerException(String message){
		super();
		this.message=message;
	}
	 @Override
	public String getMessage() {
		return message;
	}	
}
