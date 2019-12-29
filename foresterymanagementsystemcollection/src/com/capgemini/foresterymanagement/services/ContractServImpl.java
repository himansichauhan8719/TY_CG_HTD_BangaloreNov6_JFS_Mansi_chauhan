package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.ContractBean;
import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.dao.ContractDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class ContractServImpl implements ContractServ {
	ContractDao dao=FactoryDetails.objectContractDao();

	@Override
	public void showAllContractor() {
		dao.showAllContractor();
		
	}

	@Override
	public boolean modifyContract(int custId, ContractBean bean) {
		// TODO Auto-generated method stub
		return dao.modifyContract(custId, bean);
	}

	@Override
	public boolean addContract(ContractBean bean) {
		// TODO Auto-generated method stub
		return dao.addContract(bean);
	}

	@Override
	public boolean removeContract(int custId) {
		// TODO Auto-generated method stub
		return dao.removeContract(custId);
	}

	

	
}
