package com.capg.retailermanagement.dao;

import java.util.List;

import com.capg.retailermaintanance.dto.Userinfo;

public interface UserDao {
	
	public boolean addUser(Userinfo ubean);
	
	public Userinfo login(String email,String password);

	public List<Userinfo> getAllUsers();

		

	}

