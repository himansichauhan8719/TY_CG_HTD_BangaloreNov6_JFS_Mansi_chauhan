package com.capgemini.foresterymanagement.services;

import java.util.List;

import com.capgemini.foresterymanagement.bean.ContractBean;
import com.capgemini.foresterymanagement.dao.ContractDao;
import com.capgemini.foresterymanagement.dao.ContractDaoImpl;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public  class ContractServicesImpl implements ContractServices {

	ContractDao cdao = FactoryDetails.getContractDao();

	@Override
	public boolean addContract(ContractBean bean) {
		// TODO Auto-generated method stub
		return cdao.addContract(bean);
	}

	@Override
	public boolean removeContract(int prodId) {
		// TODO Auto-generated method stub
		return cdao.removeContract(prodId);
	}

	@Override
	public void showAllContract() {
		cdao.showAllContract();
		
	}

	@Override
	public boolean modifyContract(int prodId, ContractBean bean) {
		// TODO Auto-generated method stub
		return cdao.modifyContract(prodId, bean);
	}
	
	

	

}
