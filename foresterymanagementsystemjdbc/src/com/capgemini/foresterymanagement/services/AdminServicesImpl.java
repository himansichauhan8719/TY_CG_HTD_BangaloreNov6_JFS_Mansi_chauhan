package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.dao.AdminDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class AdminServicesImpl implements AdminServices{
  AdminDao adao = FactoryDetails.getAdminDao();
	
  @Override
	public boolean loginAdmin(String name, String password) {
		// TODO Auto-generated method stub
		return adao.loginAdmin(name,password);
	}

	

}
