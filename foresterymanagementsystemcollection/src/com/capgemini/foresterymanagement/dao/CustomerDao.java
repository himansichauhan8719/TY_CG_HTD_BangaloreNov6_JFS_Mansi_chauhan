package com.capgemini.foresterymanagement.dao;

import com.capgemini.foresterymanagement.bean.CustomerBean;

public interface CustomerDao {

	public void showAllCustomer();
	
    public boolean addCustomer(CustomerBean cbean);
	
	public boolean removeCustomer(int custId);
	
	public boolean modifyCustomer(int custId ,CustomerBean cbean);

	public CustomerBean getDetails(int id2);
}
