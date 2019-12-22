package com.capg.shoppingapp.services;

import java.util.List;

import com.capg.shoppingapp.bean.Product;

public interface Productservices {
	public  List<Product> getAllProduct();
	public  Product getProduct(String proName);
	
}
