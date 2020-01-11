package com.capg.retailermaintanance.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.retailermaintanance.dto.ProductResponse;
import com.capg.retailermaintanance.dto.Productinfo;
import com.capg.retailermaintanance.service.ProductServ;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
public class ProductController {

	@Autowired
	ProductServ service;
	
	@GetMapping(path="/view-product",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse viewProduct(@RequestParam("id") int id) {
		ProductResponse response = new ProductResponse();
		Productinfo product=service.getProduct(id);
		if(product!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product found");
			response.setProduct(Arrays.asList(product));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product id does not exist");
		}
		return response;
	}
	
}
