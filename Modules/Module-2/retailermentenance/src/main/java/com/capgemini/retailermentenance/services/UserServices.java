package com.capgemini.retailermentenance.services;

import com.capgemini.retailermentenance.dto.UserInfo;

public interface UserServices {
	
	public boolean addUser(UserInfo userInfo);
	
	public UserInfo loginUser(UserInfo userInfo);
	
	public boolean updatePassword(String email, String password);
	
}
