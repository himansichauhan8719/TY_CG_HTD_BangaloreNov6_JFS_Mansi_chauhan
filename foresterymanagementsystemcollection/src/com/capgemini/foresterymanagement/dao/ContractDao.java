package com.capgemini.foresterymanagement.dao;

import com.capgemini.foresterymanagement.bean.ContractBean;

public interface ContractDao {
	
	public void showAllContractor();
	
	public boolean modifyContract(int custId,ContractBean bean);
	
	public boolean addContract(ContractBean bean);
	
	public boolean removeContract(int custId);


	

}
