package com.capgemini.foresterymanagement.services;

import java.util.List;

import com.capgemini.foresterymanagement.bean.ContractBean;

public interface ContractServices {
	
public boolean addContract(ContractBean bean);
	
	public boolean removeContract(int prodId);
	
	public void showAllContract();
	
	public boolean modifyContract(int  prodId , ContractBean bean);


}
