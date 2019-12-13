package com.capg.phoneSimulatorApp.dao;

import java.util.ArrayList;
import java.util.List;

import com.capg.phoneSimulatorApp.bean.ContactBean;

public interface ContactDao {
  
	public List<ContactBean> viewAllContacts();

	public	ContactBean showContact(String name); 

	public boolean contactInsert(ContactBean cont);

	public boolean contactdelete(String name);

	public boolean contactupdate(String name,int number);



	
	
}
