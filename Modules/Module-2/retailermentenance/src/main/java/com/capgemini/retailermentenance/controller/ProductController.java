package com.capgemini.retailermentenance.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermentenance.dto.ProductInfo;
import com.capgemini.retailermentenance.response.ProductResponse;
import com.capgemini.retailermentenance.services.ProductServices;

@RestController
public class ProductController {
	@Autowired
	private ProductServices productServices;
	
	@PostMapping(path = "/add-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody ProductInfo productInfo) {
		ProductResponse response = new ProductResponse();
		if (productServices.addProduct(productInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product added");
		} 
		return response;
	}
	
	@GetMapping(path = "/view-product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse viewProduct(@PathVariable("id") int id) {
		ProductResponse response = new ProductResponse();
		ProductInfo product = productServices.getProduct(id);
		if (product != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product found");
			response.setProduct(Arrays.asList(product));
		} 
		return response;
	}
}
