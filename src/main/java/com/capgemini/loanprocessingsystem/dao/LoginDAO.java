package com.capgemini.loanprocessingsystem.dao;

import com.capgemini.loanprocessingsystem.dto.LoginBean;

public interface LoginDAO {

	public LoginBean auth(String email,String password);

	public boolean register(LoginBean bean);
	
}
