package com.capgemini.foresterymanagement.dao;

import com.capgemini.foresterymanagement.bean.ProductBean;

public interface ProductDao {
	
	public void showAllProduct();
	
	public boolean updateProduct(int custId,ProductBean pbean);
	
	public boolean deleteProduct(int custId);
	
	public boolean addProduct(ProductBean pbean);
	
	public ProductBean searchProduct(int custId);

}
