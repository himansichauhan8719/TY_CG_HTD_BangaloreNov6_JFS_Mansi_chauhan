package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.foresterymanagement.bean.CustomerBean;



public class CustomerDaoImpl implements CustomerDao {
  
	private static HashMap<Integer,CustomerBean> h1=new HashMap<Integer,CustomerBean>();
	static int cid=0;
	CustomerBean cbToLogin=null;
	
	@Override
	public void showAllCustomer() {
		System.out.println("                            ::::ALL CUSTOMER::::");
		Set<Integer> s=h1.keySet();
		for (Integer key : s) {
			CustomerBean cb=h1.get(key);
			System.out.println("CUSTOMER-ID: "+key);
			System.out.println(cb);
		}
	}

//	

	@Override
	public boolean modifyCustomer(int custid , CustomerBean cbean) {
		h1.replace(custid ,cbean );
		return true;
	}

	@Override
	public boolean removeCustomer(int cidToDelete) {
		System.out.println("The specified Customer got delated");
		h1.remove(cidToDelete);
		return true;
	}

	@Override

	public boolean addCustomer(CustomerBean cbean) {
		while(true) {
			//TO VALLIDATE THE CUSTOMER-name and EMAIL 
			//I NEED REFRENCE HENCE
			cbToLogin=cbean;
			//In-order to add generated CUSTOMER-ID to each and
			//every objects
			++cid;
			cbean.setCustId(cid);
			h1.put(cid,cbean);
			System.out.println("Customer with Customer-ID is : "+cid+" added successfully. (please remember)");
			return true;
		}
	}
	
	@Override
	public CustomerBean getDetails(int iD) {
		if(h1.containsKey(iD)) {
			return h1.get(iD);
		}
		return null;
	}



}
