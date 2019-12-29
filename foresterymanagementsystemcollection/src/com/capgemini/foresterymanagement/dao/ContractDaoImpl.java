package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.foresterymanagement.bean.ContractBean;



public class ContractDaoImpl implements ContractDao {


	private static HashMap<Integer,ContractBean> h1=new HashMap<Integer,ContractBean>();
	int ctid=0;
	@Override
	public void showAllContractor() {
		if(h1.isEmpty()==false) {
			System.out.println("                            ::::ALL CONTRACT DETAILS::::");
			Set<Integer> s=h1.keySet();
			for (Integer key : s) {
				ContractBean cb=h1.get(key);
				System.out.println("CONTRACT-ID: "+key);
				System.out.println(cb);
			}
		}else {
			System.err.println("Currently there is no contracts..!(No customer orders)");
		}
	}

	@Override
	public boolean modifyContract(int cidToUpdate, ContractBean contarctorToUpdate) {
		h1.replace(cidToUpdate,contarctorToUpdate );
		return true;

	}

	@Override
	public boolean removeContract(int cidToDelete) {
		h1.remove(cidToDelete);
		return true;
	}

	@Override
	public boolean addContract(ContractBean bean) {

		while(true) {
			++ctid;
			
			bean.setContNo(ctid);
			h1.put(ctid,bean);
			System.out.println("Contract with CONTRACT-ID : "+ctid+"  \n for CUSTOMER-ID "
					+bean.getCustId() +"is added succesfully (please remember )");
			return true;
		}	
	}


}



