package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.ProductBean;

public interface ProductServ {
	
public void showAllProduct();
	
	public boolean addProduct(ProductBean pbean);

	public boolean removeProduct(int proId);

	public boolean updateProduct(int proId,ProductBean pbean);
	
	public ProductBean searchProduct(int proId);
	
	
}
