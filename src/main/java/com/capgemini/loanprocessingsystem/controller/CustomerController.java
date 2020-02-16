package com.capgemini.loanprocessingsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.loanprocessingsystem.dto.CustomerResponse;
import com.capgemini.loanprocessingsystem.dto.Customers;
import com.capgemini.loanprocessingsystem.service.CustomerService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class CustomerController {

	@Autowired	
	CustomerService customerService;

	@GetMapping(path="/view-customers",produces=MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse viewAllCustomers() {
		CustomerResponse response=new CustomerResponse();

		List<Customers> list= customerService.getAllCustomers();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customers found");
			response.setCustomer(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;


	}
	@PostMapping(path="/insert-customers",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse addCustomer(@RequestBody Customers customers) {
		CustomerResponse response = new CustomerResponse();
		if(customerService.insertCustomer(customers)) {
			response.setStatusCode(201);
			response.setMessage("Application form  submitted successfully");
			response.setDescription("customer added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("customer with same name already exists");
		}
		return response;

	}
	@GetMapping(path="/search-customer/{id}", produces =MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse searchCustomer(@PathVariable("id") int id) {
		CustomerResponse customerResponse = new CustomerResponse();
		Customers customers = customerService.searchCustomers(id);
		if(customers!=null) {
			customerResponse.setStatusCode(201);
			customerResponse.setDescription("Customer Found");
			customerResponse.setMessage("Success");
			customerResponse.getCustomer();
			//			customerResponse.getCustomer();
			customerResponse.setCustomer(Arrays.asList(customers));	

		}else {
			customerResponse.setStatusCode(401);
			customerResponse.setMessage("Failure");
			customerResponse.setDescription("Customer with this Application Id doesn't exist");

		}
		return customerResponse;
	}
}