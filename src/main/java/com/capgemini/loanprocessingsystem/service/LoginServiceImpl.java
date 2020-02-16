package com.capgemini.loanprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.LoginDAO;
import com.capgemini.loanprocessingsystem.dto.LoginBean;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO dao;
	
	@Override
	public LoginBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	@Override
	public boolean register(LoginBean bean) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(bean.getPassword());
		bean.setPassword(encodedPassword);
		return dao.register(bean);
	}

	
}
