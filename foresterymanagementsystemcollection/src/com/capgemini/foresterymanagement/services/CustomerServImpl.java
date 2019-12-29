package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.dao.CustomerDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;


public class CustomerServImpl implements CustomerServ {
	CustomerDao dao=FactoryDetails.objectCustomerDao();

	@Override
	public void showAllCustomer() {
		dao.showAllCustomer();
		
	}

	@Override
	public boolean addCustomer(CustomerBean cbean) {
		// TODO Auto-generated method stub
		return dao.addCustomer(cbean);
	}

	@Override
	public boolean removeCustomer(int custId) {
		// TODO Auto-generated method stub
		return dao.removeCustomer(custId);
	}

	@Override
	public boolean modifyCustomer(int custId, CustomerBean cbean) {
		// TODO Auto-generated method stub
		return dao.modifyCustomer(custId, cbean);
	}

	@Override
	public CustomerBean getDetails(int id2) {
		// TODO Auto-generated method stub
		return dao.getDetails(id2);
	}

    

	
}
