package com.capgemini.retailermentenance.services;

import com.capgemini.retailermentenance.dto.ProductInfo;

public interface ProductServices {
	
	public ProductInfo getProduct(int id);
	
	public boolean addProduct(ProductInfo productInfo);

}
