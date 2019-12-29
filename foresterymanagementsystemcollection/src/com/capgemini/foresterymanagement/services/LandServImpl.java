package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.LandBean;
import com.capgemini.foresterymanagement.dao.LandDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class LandServImpl implements LandServ {
	LandDao dao=FactoryDetails.objectDAOLand();

	@Override
	public void showAllLands() {
		dao.showAllLands();
		
	}

	@Override
	public boolean addLand(LandBean land) {
		// TODO Auto-generated method stub
		return dao.addLand(land);
	}


	@Override
	public boolean removeLand(int custId) {
		// TODO Auto-generated method stub
		return dao.removeLand(custId);
	}

	@Override
	public LandBean searchLand(int custId) {
		// TODO Auto-generated method stub
		return dao.searchLand(custId);
	}

	@Override
	public boolean modifyLand(LandBean lbean) {
		// TODO Auto-generated method stub
		return dao.modifyLand(0, lbean);
	}

	
	
}
