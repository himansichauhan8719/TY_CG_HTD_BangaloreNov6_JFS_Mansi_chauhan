package com.capgemini.loanprocessingsystem.dto;

import java.util.List;




public class VerificationResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<Verification> verification;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Verification> getVerification() {
		return verification;
	}
	public void setVerification(List<Verification> verification) {
		this.verification = verification;
	}
	
	
}
