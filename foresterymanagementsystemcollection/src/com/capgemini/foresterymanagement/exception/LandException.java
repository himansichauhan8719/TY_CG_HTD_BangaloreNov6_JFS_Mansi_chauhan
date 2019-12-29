package com.capgemini.foresterymanagement.exception;

public class LandException extends RuntimeException {
	String message;
	public LandException() {		
	}
	public LandException(String message){
		super();
		this.message=message;
	}
	 @Override
	public String getMessage() {
		return super.getMessage();
	}
}
