package com.capgemini.forestrymanagement.util;

import com.capgemini.forestrymanagement.forestrydao.ContractDAO;
import com.capgemini.forestrymanagement.forestrydao.ContractDAOImpl;
import com.capgemini.forestrymanagement.forestrydao.CustomerDAO;
import com.capgemini.forestrymanagement.forestrydao.CustomerDAOImpl;
import com.capgemini.forestrymanagement.forestrydao.ProductDAO;
import com.capgemini.forestrymanagement.forestrydao.ProductDAOImpl;

public class ForestryManagementDAO {
	
	public static ContractDAO getContractDAO() {
		return new ContractDAOImpl();
	}
	
	public static CustomerDAO getCustomerDAO() {
		return new CustomerDAOImpl();
	}
	
	public static ProductDAO getProductDAO() {
		return new ProductDAOImpl();
		
	}

}
