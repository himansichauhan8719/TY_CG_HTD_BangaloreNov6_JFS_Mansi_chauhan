package com.capgemini.retailermentenance.dao;

import com.capgemini.retailermentenance.dto.ProductInfo;

public interface ProductDao {

	public ProductInfo getProduct(int id);
	
	public boolean addProduct(ProductInfo productInfo);

}
