package com.capgemini.foresterymanagement.dao;

import com.capgemini.foresterymanagement.bean.CustomerBean;

public interface CustomerDao {
	
	        public boolean addCustomer(CustomerBean bean);
			
			public void showAllCustomers();
			
			public boolean removeCustomer(int custId);
			
			public boolean modifyCustomer(int custId);
			
		
}
