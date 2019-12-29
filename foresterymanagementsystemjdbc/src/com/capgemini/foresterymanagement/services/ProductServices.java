package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.ProductBean;

public interface ProductServices {
	
    public void showAllProduct();
	
	public boolean updateProduct(int custId,ProductBean pbean);
	
	public boolean deleteProduct(int custId);
	
	public boolean addProduct(ProductBean pbean);
	
	public ProductBean searchProduct(int custId);
}
