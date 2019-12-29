package com.capgemini.foresterymanagement.dao;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean loginAdmin(String name, String password) {
			try {
				String adminname = "root123";
				String adminpassword = "root123";
				
				if ((adminname.equals(name))&&(adminpassword.equals(password))) {
					return true;
				} else {
					return false;
				}
				
			} catch(Exception e) {
				System.out.println("::::: Username and password is wrong :( ::::: ");
				return false;
				}
	}

}
