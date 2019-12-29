package com.capgemini.foresterymanagement.dao;

import com.capgemini.foresterymanagement.bean.LandBean;

public interface LandDao {

	public void showAllLands();
	
	public boolean addLand(LandBean land);
	
	public boolean modifyLand(int custId,LandBean lbean);

	public boolean removeLand(int custId);
	
	public LandBean searchLand(int custId);
}
