package com.capgemini.foresterymanagement.services;


import com.capgemini.foresterymanagement.bean.ContractBean;


public interface ContractServ {
	
public void showAllContractor();
	
	public boolean modifyContract(int custId,ContractBean bean);
	
	public boolean addContract(ContractBean bean);
	
	public boolean removeContract(int custId);
}
