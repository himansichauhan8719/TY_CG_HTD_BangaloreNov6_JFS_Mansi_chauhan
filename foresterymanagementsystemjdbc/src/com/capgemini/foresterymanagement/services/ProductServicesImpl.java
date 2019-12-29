package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.dao.ProductDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class ProductServicesImpl implements ProductServices {

	ProductDao pdao = FactoryDetails.getProductDao();
	@Override
	public void showAllProduct() {
		
		pdao.showAllProduct();
	}

	@Override
	public boolean updateProduct(int custId,ProductBean pbean) {
		// TODO Auto-generated method stub
		return pdao.updateProduct(custId,pbean);
	}

	@Override
	public boolean deleteProduct(int custId) {
		// TODO Auto-generated method stub
		return pdao.deleteProduct(custId);
	}

	@Override
	public boolean addProduct(ProductBean pbean) {
		// TODO Auto-generated method stub
		return pdao.addProduct(pbean);
	}

	@Override
	public ProductBean searchProduct(int custId) {
		// TODO Auto-generated method stub
		return pdao.searchProduct(custId);
	}

}
