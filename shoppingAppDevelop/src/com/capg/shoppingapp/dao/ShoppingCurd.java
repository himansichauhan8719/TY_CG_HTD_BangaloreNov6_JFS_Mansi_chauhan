package com.capg.shoppingapp.dao;

import java.util.List;

import com.capg.shoppingapp.bean.Product;

public interface ShoppingCurd {

	

	
public  List<Product> getAllProduct();
public  Product getProduct(String proName);

	
}
