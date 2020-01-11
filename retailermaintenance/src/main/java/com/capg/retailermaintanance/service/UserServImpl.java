package com.capg.retailermaintanance.service;

import java.util.List;

import com.capg.retailermaintanance.dto.Userinfo;
import com.capg.retailermanagement.dao.UserDao;

public class UserServImpl implements UserServ {
	
	private UserDao udao;

	@Override
	public boolean addUser(Userinfo ubean) {
		// TODO Auto-generated method stub
		return udao.addUser(ubean);
	}

	@Override
	public List<Userinfo> getAllUsers() {
		// TODO Auto-generated method stub
		return udao.getAllUsers();
	}

	@Override
	public Userinfo login(String email, String password) {
		// TODO Auto-generated method stub
		return udao.login(email, password);
	}

}
