package com.capgemini.loanprocessingsystem.dto;

import java.util.List;



public class LoginResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<LoginBean> login;
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
	public List<LoginBean> getLogin() {
		return login;
	}
	public void setLogin(List<LoginBean> login) {
		this.login = login;
	}
	
}
