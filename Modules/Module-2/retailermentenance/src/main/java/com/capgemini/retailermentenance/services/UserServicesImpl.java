package com.capgemini.retailermentenance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermentenance.dao.UserDao;
import com.capgemini.retailermentenance.dto.UserInfo;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDao userDao;
	@Override
	public boolean addUser(UserInfo userInfo) {
		return userDao.addUser(userInfo);
	}

	@Override
	public UserInfo loginUser(UserInfo userInfo) {
		return userDao.loginUser(userInfo);
	}

	@Override
	public boolean updatePassword(String email, String password) {
		return userDao.updatePassword(email, password);
	}

	
}
