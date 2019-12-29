package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.CustomerBean;

public interface CustomerServices {

	public boolean addCustomer(CustomerBean bean);
	
	public void showAllCustomers();
	
	public boolean removeCustomer(int custId);
	
	public boolean modifyCustomer(int custId);
	
}
