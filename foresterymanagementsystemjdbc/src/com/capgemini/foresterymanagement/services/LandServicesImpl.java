package com.capgemini.foresterymanagement.services;

import java.util.List;

import com.capgemini.foresterymanagement.bean.LandBean;
import com.capgemini.foresterymanagement.dao.LandDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class LandServicesImpl implements LandServices {

	LandDao ldao = FactoryDetails.getLandDao();

	@Override
	public void getAllLands() {
		
		 ldao.getAllLands();
	}

	@Override
	public boolean addLand(LandBean land) {
		// TODO Auto-generated method stub
		return ldao.addLand(land);
	}

	@Override
	public boolean deleteLand(int custId) {
		// TODO Auto-generated method stub
		return ldao.deleteLand(custId);
	}

	@Override
	public boolean modifyLand(int custId, LandBean land) {
		// TODO Auto-generated method stub
		return ldao.modifyLand(custId, land);
	}

}
