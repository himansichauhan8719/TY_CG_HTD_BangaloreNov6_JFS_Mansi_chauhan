package com.capgemini.retailermentenance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermentenance.dao.ProductDao;
import com.capgemini.retailermentenance.dto.ProductInfo;

@Service
public class ProductServicesImpl implements ProductServices{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public ProductInfo getProduct(int id) {
		return productDao.getProduct(id);
	}

	@Override
	public boolean addProduct(ProductInfo productInfo) {
		return productDao.addProduct(productInfo);
	}

	
}
