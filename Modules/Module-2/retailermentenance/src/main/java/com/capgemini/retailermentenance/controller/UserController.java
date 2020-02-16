package com.capgemini.retailermentenance.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermentenance.dto.UserInfo;
import com.capgemini.retailermentenance.response.ProductResponse;
import com.capgemini.retailermentenance.response.UserResponse;
import com.capgemini.retailermentenance.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userServices;
	
	
	@PostMapping(path = "/add-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse addUser(@RequestBody UserInfo userInfo) {
		UserResponse userResponse = new UserResponse();
		if (userServices.addUser(userInfo)) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("success");
			userResponse.setDescription("User Added Successfully");
		}
		return userResponse;
	}
	
	@PutMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse modifyPassword(@RequestBody UserInfo userInfo) {
		UserResponse userResponse = new UserResponse();
		if (userServices.updatePassword(userInfo.getEmail(), userInfo.getPassword())) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("Password Changed Successfully");
		} 
		return userResponse;
	}
	
	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse login(@RequestBody UserInfo userInfo) {
		UserResponse userResponse = new UserResponse();
		UserInfo user = userServices.loginUser(userInfo);
		if (user != null) {
			userResponse.setStatusCode(201);
			userResponse.setDescription("Success");
			userResponse.setMessage("Logged in");
			userResponse.setUser(Arrays.asList(user));
		} 
		return userResponse;
	}

	
	
	
	
}
