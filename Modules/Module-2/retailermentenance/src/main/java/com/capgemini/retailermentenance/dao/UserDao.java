package com.capgemini.retailermentenance.dao;

import com.capgemini.retailermentenance.dto.UserInfo;

public interface UserDao {

	public boolean addUser(UserInfo userInfo);

	public UserInfo loginUser(UserInfo userInfo);

	public boolean updatePassword(String email, String Password);

}
