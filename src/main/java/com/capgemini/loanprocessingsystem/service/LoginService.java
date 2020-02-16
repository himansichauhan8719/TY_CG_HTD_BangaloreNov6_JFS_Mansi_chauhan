package com.capgemini.loanprocessingsystem.service;

import com.capgemini.loanprocessingsystem.dto.LoginBean;

public interface LoginService {

	public LoginBean auth(String email,String password);
	public boolean register(LoginBean bean);

}
