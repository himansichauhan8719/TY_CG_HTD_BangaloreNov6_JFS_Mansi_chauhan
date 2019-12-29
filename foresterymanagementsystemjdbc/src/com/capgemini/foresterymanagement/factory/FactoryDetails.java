package com.capgemini.foresterymanagement.factory;

import com.capgemini.foresterymanagement.bean.AdminBean;
import com.capgemini.foresterymanagement.bean.ContractBean;
import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.bean.LandBean;
import com.capgemini.foresterymanagement.bean.ProductBean;
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
import com.capgemini.foresterymanagement.services.AdminServices;
import com.capgemini.foresterymanagement.services.AdminServicesImpl;
import com.capgemini.foresterymanagement.services.ContractServices;
import com.capgemini.foresterymanagement.services.ContractServicesImpl;
import com.capgemini.foresterymanagement.services.CustomerServices;
import com.capgemini.foresterymanagement.services.CustomerServicesImpl;
import com.capgemini.foresterymanagement.services.LandServices;
import com.capgemini.foresterymanagement.services.LandServicesImpl;
import com.capgemini.foresterymanagement.services.ProductServices;
import com.capgemini.foresterymanagement.services.ProductServicesImpl;

public class FactoryDetails {
 public FactoryDetails() {
	 
 }
 
 public static ContractServices getContractServ() {
	 ContractServicesImpl conserv = new ContractServicesImpl();
	 return  conserv;
 }
 
 public static ContractDao getContractDao() {
	 ContractDaoImpl condao = new ContractDaoImpl();
	 return  condao;
 }

public static ContractBean getContractBean() {
	   ContractBean conbean = new ContractBean();
	return  conbean;
}

public static AdminDao getAdminDao() {
	AdminDaoImpl adao = new AdminDaoImpl();
	return adao;
}

public static AdminServices getAdminserv() {
	AdminServicesImpl adao1 = new AdminServicesImpl();
	return adao1;
}
 
public static AdminBean getAdminBean() {
	AdminBean abean = new AdminBean();
	return abean;
}

public static LandServices getLandServ() {
	 LandServicesImpl lserv = new LandServicesImpl();
	 return  lserv;
}

public static LandDao getLandDao() {
	 LandDaoImpl ldao = new LandDaoImpl();
	 return  ldao;
}

public static LandBean getLandBean() {
	   LandBean conbean = new LandBean();
	return  conbean;
}
public static ProductServices getProductServ() {
	 ProductServicesImpl pserv = new ProductServicesImpl();
	 return  pserv;
}

public static ProductDao getProductDao() {
	 ProductDaoImpl pdao = new ProductDaoImpl();
	 return  pdao;
}

public static ProductBean getProductBean() {
	   ProductBean pbean = new ProductBean();
	return  pbean;
}
public static CustomerServices getCustomerServ() {
	 CustomerServicesImpl conserv = new CustomerServicesImpl();
	 return  conserv;
}

public static CustomerDao getCustomerDao() {
	 CustomerDaoImpl condao = new CustomerDaoImpl();
	 return  condao;
}

public static CustomerBean getCustomerBean() {
	   CustomerBean conbean = new CustomerBean();
	return  conbean;
}
}
