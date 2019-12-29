package com.capgemini.foresterymanagement.services;


import com.capgemini.foresterymanagement.bean.LandBean;

public interface LandServices {
	
public void getAllLands();
	
    public boolean addLand(LandBean land);
	
    public boolean deleteLand(int custId);

	public boolean modifyLand(int custId,LandBean land);
}
