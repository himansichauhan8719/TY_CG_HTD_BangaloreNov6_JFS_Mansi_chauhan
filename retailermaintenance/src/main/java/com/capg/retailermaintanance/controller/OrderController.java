package com.capg.retailermaintanance.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.retailermaintanance.dto.OrderResponse;
import com.capg.retailermaintanance.dto.Orderinfo;
import com.capg.retailermaintanance.service.OrderServ;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
public class OrderController {
  
	@Autowired
	OrderServ service;
	
	@GetMapping(path="/view-order",produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse viewOrder(@RequestParam("id") int id) {
		OrderResponse response = new OrderResponse();
		Orderinfo product=service.getOrder(id);
		if(product!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Order found");
			response.setOrder(Arrays.asList(product));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Order id does not exist");
		}
		return response;
	}
	
}
