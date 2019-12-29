package com.capgemini.foresterymanagement.dao;


import com.capgemini.foresterymanagement.bean.ContractBean;

public interface ContractDao {
	
	public boolean addContract(ContractBean bean);
	
	public boolean removeContract(int prodId);
	
	public void showAllContract();
	
	public boolean modifyContract(int  prodId , ContractBean bean);
}
