package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.dao.AdminDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class AdminServImpl implements AdminServ{

	AdminDao adao = FactoryDetails.objectAdminDao();
	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		return adao.login(name, password);
	}

}
