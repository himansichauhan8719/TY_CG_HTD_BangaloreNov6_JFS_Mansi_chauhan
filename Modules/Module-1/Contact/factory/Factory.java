package com.capgemini.contact.factory;

import com.capgemini.contact.bean.ContactBean;
import com.capgemini.contact.dao.ContactDao;
import com.capgemini.contact.dao.ContactDaoImpl;
import com.capgemini.contact.services.ContactServiceImpl;
import com.capgemini.contact.services.ContactServices;

public class Factory {
	private Factory() {
		
	}

	public static ContactServices getServ1() {
		ContactServiceImpl serv =	new ContactServiceImpl();
		return  (ContactServices) serv;
	}
	
	public static ContactDao getDao() {
		ContactDaoImpl dao = new ContactDaoImpl();
		return (ContactDao) dao;
	}
	
	public static ContactBean getBean() {
		ContactBean bean = new ContactBean();
		return bean;
	}
}
