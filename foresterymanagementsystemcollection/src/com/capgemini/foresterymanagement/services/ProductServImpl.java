package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.dao.ProductDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class ProductServImpl implements ProductServ {
	ProductDao dao=FactoryDetails.objectProductDao();

	@Override
	public void showAllProduct() {
		dao.showAllProduct();
		
	}

	@Override
	public boolean addProduct(ProductBean pbean) {
		// TODO Auto-generated method stub
		return dao.addProduct(pbean);
	}

	@Override
	public boolean removeProduct(int proId) {
		// TODO Auto-generated method stub
		return dao.removeProduct(proId);
	}

	@Override
	public boolean updateProduct(int proId, ProductBean pbean) {
		// TODO Auto-generated method stub
		return dao.updateProduct(proId, pbean);
	}

	@Override
	public ProductBean searchProduct(int proId) {
		// TODO Auto-generated method stub
		return dao.searchProduct(proId);
	}

	




}
