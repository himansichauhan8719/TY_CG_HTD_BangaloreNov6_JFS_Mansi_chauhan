package com.capgemini.contact.services;

import java.util.List;

import com.capgemini.contact.bean.ContactBean;
import com.capgemini.contact.dao.ContactDaoImpl;
import com.capgemini.contact.factory.Factory;

public class ContactServiceImpl implements ContactServices {
	
	ContactDaoImpl dao = (ContactDaoImpl) Factory.getDao();
	
	@Override
	public boolean addContact(ContactBean bean) {
		// TODO Auto-generated method stub
		return dao.addContact(bean);
	}

	@Override
	public boolean deleteContact(String name) {
		// TODO Auto-generated method stub
		return dao.deleteContact(name);
	}

	@Override
	public boolean editContact(String name) {
		return dao.editContact(name);
	}

	public List<ContactBean> searchContact(String name) {
		// TODO Auto-generated method stub
		return dao.searchContact(name);
	}

	public List<ContactBean> allContact() {
		// TODO Auto-generated method stub
		return dao.allContact();
	}

}
