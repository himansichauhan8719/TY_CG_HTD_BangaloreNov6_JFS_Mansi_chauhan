package com.capgemini.forestrymanagement.forestrydao;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.forestrybean.CustomerBean;

public interface CustomerDAO {
	public boolean addCustomer(CustomerBean cbean);
	public boolean modifyCustomer(CustomerBean custBean);
	public boolean deleteCustomer(int customerId);
	public ArrayList<CustomerBean> showAllCustomer();
	public CustomerBean getCustomer(int customerId);
    }
