package com.capgemini.foresterymanagement.dao;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.foresterymanagement.bean.AdminBean;

public class AdminDaoImpl implements AdminDao {
//	
//	TreeMap<String, String> client= new TreeMap<String, String>();
//	TreeMap<String, String> scheduler= new TreeMap<String, String>();
//
//	public void addAdmin(AdminBean bean) {
//		if(client.containsKey(bean.getName())) {
//			System.err.println("Duplicate entry for client account");
//		} else {
//			client.put(bean.getName(),bean.getPassword());
//			System.out.println("Client account created");
//		}
//
//	}
//	@Override
//	public void showAdmin() {
//		if(client.size()!=0) {
//			Set<Map.Entry<String, String>> s1=client.entrySet();
//			for (Map.Entry<String, String> entry : s1) {
//				System.out.println("--------------");
//				System.out.println("Client username :"+entry.getKey());
//				System.out.println("Client password :"+entry.getValue());
//				System.out.println("---------------\n");
//			}
//		} else {
//			System.out.println("no data");
//		}
//
//	}
//	@Override
//	public void removeCust(String username) {
//		if(client.containsKey(username)) {
//			client.remove(username);
//			System.out.println("client account deleted");
//		} else {
//			System.out.println("client account not found");
//		}
//
//	}
//	
//	@Override
//	public void updateCust(AdminBean bean) {
//		
//		client.put(bean.getName(), bean.getPassword());
//		System.out.println("Password updated");
//	}
//	
//	@Override
//	public boolean checkCust(String username, String password) {
//		if(client.containsKey(username)&&client.containsValue(password)) {
//			return true;
//		}
//		return false;
//	}
//	@Override
//	public void showCust(String username) {
//		if(client.containsKey(username)) {
//			System.out.println("Username is "+username);
//			String password=client.get(username);
//			System.out.println("Password is "+password);
//		} else {
//			System.out.println("Client account not found");
//		}
//
//	}

	@Override
	public boolean login(String name, String password) {
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
