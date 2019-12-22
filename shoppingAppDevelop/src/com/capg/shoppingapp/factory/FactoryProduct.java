package com.capg.shoppingapp.factory;



import com.capg.shoppingapp.dao.ShoppingCurd;
import com.capg.shoppingapp.dao.ShoppingCurdImpl;
import com.capg.shoppingapp.services.Productservices;
import com.capg.shoppingapp.services.ProductservicesImpl;

public class FactoryProduct {
	private FactoryProduct() {

	}
	
	public static Productservices objectofProductservices() {
		Productservices services=new ProductservicesImpl();
		return services;
	}
	public static ShoppingCurd instanceOfProductDaoImpl() {
		ShoppingCurd dao= new ShoppingCurdImpl();
		return dao;
		
	}
	
}
