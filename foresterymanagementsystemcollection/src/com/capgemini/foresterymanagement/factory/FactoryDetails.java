package com.capgemini.foresterymanagement.factory;

import com.capgemini.foresterymanagement.dao.AdminDao;
import com.capgemini.foresterymanagement.dao.AdminDaoImpl;
import com.capgemini.foresterymanagement.dao.ContractDao;
import com.capgemini.foresterymanagement.dao.ContractDaoImpl;
import com.capgemini.foresterymanagement.dao.CustomerDao;
import com.capgemini.foresterymanagement.dao.CustomerDaoImpl;
import com.capgemini.foresterymanagement.dao.LandDao;
import com.capgemini.foresterymanagement.dao.LandDaoImpl;
import com.capgemini.foresterymanagement.dao.ProductDao;
import com.capgemini.foresterymanagement.dao.ProductDaoImpl;
import com.capgemini.foresterymanagement.services.AdminServ;
import com.capgemini.foresterymanagement.services.AdminServImpl;
import com.capgemini.foresterymanagement.services.ContractServ;
import com.capgemini.foresterymanagement.services.ContractServImpl;
import com.capgemini.foresterymanagement.services.CustomerServ;
import com.capgemini.foresterymanagement.services.CustomerServImpl;
import com.capgemini.foresterymanagement.services.LandServ;
import com.capgemini.foresterymanagement.services.LandServImpl;
import com.capgemini.foresterymanagement.services.ProductServ;
import com.capgemini.foresterymanagement.services.ProductServImpl;

public class FactoryDetails {
 private FactoryDetails() {
	 
 }
 
   public static AdminDao objectAdminDao() {
	   AdminDao adao = new AdminDaoImpl();
	   return adao;
   }
	
   public static AdminServ objectAdminServ() {
	   AdminServ sdao = new AdminServImpl();
	   return sdao;
   }
	
	public static ContractDao objectContractDao() {
		ContractDao cond = new ContractDaoImpl();
		return cond;
	}
	
	public static ContractServ objectContractServices() {
		ContractServ conServ = new ContractServImpl();
		return conServ;
	}
	
	public static CustomerDao objectCustomerDao() {
		CustomerDao daoc = new CustomerDaoImpl();
		return daoc;
	}
	
	public static CustomerServ objectCustomerServices() {
		CustomerServ custServ = new CustomerServImpl();
		return custServ;
	}
	
 public static LandDao objectDAOLand() {
 	LandDao daol = new LandDaoImpl();
 	return daol;
 }
 
 public static LandServ objectLandServices() {
		LandServ lServ =new LandServImpl();
		return lServ;
	}
 
 public static ProductDao objectProductDao() {
 	ProductDao daop = new ProductDaoImpl();
 	return daop;
 }
 
 public static ProductServ objectProductServices() {
 	ProductServ proServ = new ProductServImpl();
 	return proServ;
 }



}
