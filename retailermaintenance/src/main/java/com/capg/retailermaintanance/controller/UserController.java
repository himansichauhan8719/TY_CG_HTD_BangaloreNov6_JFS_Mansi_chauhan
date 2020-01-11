package com.capg.retailermaintanance.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.retailermaintanance.dto.UserResponse;
import com.capg.retailermaintanance.dto.Userinfo;
import com.capg.retailermaintanance.service.UserServ;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
public class UserController {

	@Autowired
	UserServ service;
	
	@PostMapping(path="/add-user",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse addUser(@RequestBody Userinfo product) {
		UserResponse response = new UserResponse();
		if(service.addUser(product)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product not added!!!");
		}
		return response;
	}
	
	@GetMapping(path="/user-login",produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse login(@RequestParam("email") String email, @RequestParam("password") String password) {
		UserResponse response=new UserResponse();
		Userinfo user=service.login(email,password);

			if(user.getEmail().equalsIgnoreCase(email)&&user.getPassword().equalsIgnoreCase(password)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Login Successful...");
			response.setUser(Arrays.asList(user));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Incorrect credentials!!!");
		}
		return response;
	}
	
	@GetMapping(path="/view-allusers",produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse viewAllUsers() {
		UserResponse response = new UserResponse();
		List<Userinfo> list=service.getAllUsers();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Products found");
			response.setUser(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;
		
	}
}
