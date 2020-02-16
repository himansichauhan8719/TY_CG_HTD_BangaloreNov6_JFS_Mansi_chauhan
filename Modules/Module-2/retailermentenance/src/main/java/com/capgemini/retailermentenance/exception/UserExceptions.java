
package com.capgemini.retailermentenance.exception;

public class UserExceptions extends RuntimeException {
	
String msg;
	
	public UserExceptions(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
