package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.LandBean;

public interface LandServ {
	
public void showAllLands();
	
	public boolean addLand(LandBean land);
	
	public boolean modifyLand(LandBean lbean);

	public boolean removeLand(int custId);
	
	public LandBean searchLand(int custId);

}
