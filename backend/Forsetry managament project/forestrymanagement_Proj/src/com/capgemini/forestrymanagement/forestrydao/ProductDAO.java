package com.capgemini.forestrymanagement.forestrydao;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.forestrybean.CustomerBean;
import com.capgemini.forestrymanagement.forestrybean.ProductBean;

public interface ProductDAO {
	public boolean addProduct(ProductBean productbean);
	public boolean modifyProduct(int productId);
	public boolean deleteProduct(int productId);
	public ArrayList<ProductBean> showAllProduct();
	public ProductBean getProduct(int productid);
	public void modifyProduct(ProductBean bean);
}
