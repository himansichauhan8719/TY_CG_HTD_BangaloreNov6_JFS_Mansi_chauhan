package com.capgemini.foresterymanagement.exception;

public class ContractException extends RuntimeException {
	String message;
	public ContractException() {
		
	}
	public ContractException(String message){
		super();
		this.message=message;
	}
	 @Override
	public String getMessage() {
		return super.getMessage();
	}
}
