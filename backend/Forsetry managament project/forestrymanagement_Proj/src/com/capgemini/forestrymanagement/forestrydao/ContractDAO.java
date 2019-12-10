package com.capgemini.forestrymanagement.forestrydao;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.forestrybean.ContractBean;
import com.capgemini.forestrymanagement.forestrybean.ProductBean;

public interface ContractDAO {
	public boolean addContractor(ContractBean bean);
	public boolean deleteContractor(int contractNo);
	public ArrayList<ContractBean> showAllContract();
}
