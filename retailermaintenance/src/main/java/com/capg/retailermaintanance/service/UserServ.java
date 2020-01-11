package com.capg.retailermaintanance.service;

import java.util.List;

import com.capg.retailermaintanance.dto.Userinfo;

public interface UserServ {

	public boolean addUser(Userinfo ubean);

	public Userinfo login(String email,String password);
	
	public List<Userinfo> getAllUsers();
	
	
}
