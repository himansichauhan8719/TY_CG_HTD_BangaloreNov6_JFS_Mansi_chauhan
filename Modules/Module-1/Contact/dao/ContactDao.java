package com.capgemini.contact.dao;

import java.util.List;

import com.capgemini.contact.bean.ContactBean;

public interface ContactDao {
	public boolean addContact(ContactBean bean);
	public boolean deleteContact(String name);
	public boolean editContact(String name );
	public List<ContactBean> searchContact(String name);
	public List<ContactBean> allContact();

}
