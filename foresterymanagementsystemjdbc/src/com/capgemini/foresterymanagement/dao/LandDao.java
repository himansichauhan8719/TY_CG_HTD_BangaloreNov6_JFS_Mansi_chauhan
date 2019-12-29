package com.capgemini.foresterymanagement.dao;

import java.util.List;

import com.capgemini.foresterymanagement.bean.LandBean;

public interface LandDao {
	
	public void getAllLands();
	
    public boolean addLand(LandBean land);
	
    public boolean deleteLand(int custId);

	public boolean modifyLand(int custId,LandBean land);

	
}
