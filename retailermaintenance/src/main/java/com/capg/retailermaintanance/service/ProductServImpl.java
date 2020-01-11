package com.capg.retailermaintanance.service;

import com.capg.retailermaintanance.dto.Productinfo;
import com.capg.retailermanagement.dao.ProductDao;

public class ProductServImpl implements ProductServ{

	private ProductDao pdao;
	@Override
	public Productinfo getProduct(int proid) {
		// TODO Auto-generated method stub
		return pdao.getProduct(proid) ;
	}

}
