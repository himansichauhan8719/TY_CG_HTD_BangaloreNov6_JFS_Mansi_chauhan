package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.dao.CustomerDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class CustomerServicesImpl implements CustomerServices{
   
	
	CustomerDao cdao1 = FactoryDetails.getCustomerDao();
	@Override
	public boolean addCustomer(CustomerBean bean) {
		// TODO Auto-generated method stub
		return cdao1.addCustomer(bean);
		
	}

	@Override
	public void showAllCustomers() {
		// TODO Auto-generated method stub
		
		cdao1.showAllCustomers();
	}

	@Override
	public boolean removeCustomer(int custId) {
		// TODO Auto-generated method stub
		return cdao1.removeCustomer(custId);
	}

	@Override
	public boolean modifyCustomer(int custId) {
		// TODO Auto-generated method stub
		return cdao1.modifyCustomer(custId);
	}

	
}
