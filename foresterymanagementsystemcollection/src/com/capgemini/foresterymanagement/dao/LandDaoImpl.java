package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.foresterymanagement.bean.LandBean;

public class LandDaoImpl implements LandDao {
	private static HashMap<Integer,LandBean> h1=new HashMap<Integer,LandBean>();
	int lid=0;

	@Override
	public void showAllLands() {
		try{
			System.out.println("                            ::::ALL LANDS::::");
			Set<Integer> s=h1.keySet();
			for (Integer key : s) {
				System.out.println("LAND-ID: "+key);
				LandBean cb=h1.get(key);
				System.out.println(cb);
			}
		}catch (Exception e) {
			System.err.println("There is problem in displaying all the lands");
		}		
	}


	@Override
	public boolean modifyLand(int landid, LandBean lbean) {
		h1.replace(landid,lbean );
		return true;
	}

	@Override
	public boolean removeLand(int custid) {
		System.out.println("The specified Land got delated");
		h1.remove(custid);
		return true;
	}

	@Override
	public boolean addLand(LandBean Land) {
		while(true) {
			//In-order to add generated CUSTOMER-ID to each and
			//every objects
			++lid;
			Land.setLandId(lid);
			h1.put(lid,Land);
			System.out.println("Land with LAND-ID is : "+lid+", added successfully. (please remember)");
			return true;
		}	
	}

	@Override
	public LandBean searchLand(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
