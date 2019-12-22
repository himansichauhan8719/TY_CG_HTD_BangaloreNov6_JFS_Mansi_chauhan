package com.capg.shoppingapp.controller;

import java.util.List;

import com.capg.shoppingapp.bean.Product;
import com.capg.shoppingapp.factory.FactoryProduct;
import com.capg.shoppingapp.services.Productservices;

public class ProductList {
	public void list() {
		Productservices services1=FactoryProduct.objectofProductservices();
		List<Product> l1=services1.getAllProduct();
		if(l1!=null) {
			for (Product user : l1) {
				System.out.println(user);
			}
		}
		else {
			System.out.println("product details not found....!!!");
		}
	}
}
