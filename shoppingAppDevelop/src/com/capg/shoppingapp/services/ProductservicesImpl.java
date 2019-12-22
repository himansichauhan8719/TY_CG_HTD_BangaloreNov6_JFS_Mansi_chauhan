package com.capg.shoppingapp.services;

import java.util.List;

import com.capg.shoppingapp.bean.Product;
import com.capg.shoppingapp.dao.ShoppingCurd;
import com.capg.shoppingapp.factory.FactoryProduct;

public class ProductservicesImpl implements Productservices {

	ShoppingCurd dao=FactoryProduct.instanceOfProductDaoImpl();

	@Override
	public List<Product> getAllProduct() {
		return dao.getAllProduct();
	}

	@Override
	public Product getProduct(String proName) {
		return dao.getProduct(proName);
	}

	
	
}
