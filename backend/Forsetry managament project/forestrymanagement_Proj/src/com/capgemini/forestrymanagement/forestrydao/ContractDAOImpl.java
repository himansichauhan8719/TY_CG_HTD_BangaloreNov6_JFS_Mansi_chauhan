package com.capgemini.forestrymanagement.forestrydao;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.forestrybean.ContractBean;

public class ContractDAOImpl implements ContractDAO {
	private ArrayList<ContractBean> cblist = new ArrayList<ContractBean>();

	@Override
	public boolean addContractor(ContractBean bean) {
		for (ContractBean contractbean : cblist) {
			if (contractbean.getContractNo() == bean.getContractNo()) {
				System.out.println("Contract with Same id already exists..!!!");
				return false;
			}
		}
		cblist.add(bean);
		System.out.println("Contract Details Added Syccessfully...");
		return true;
	}

	@Override
	public boolean deleteContractor(int contractNo) {
		ContractBean bean = null;
		for (ContractBean contractbean : cblist) {
			if (contractbean.getContractNo() == contractNo) {
				bean = contractbean;
			}
		}
		if (bean != null) {
			cblist.remove(bean);
			System.out.println("Record removed Successfully...");
			return true;
		}
		System.out.println("Either Contract not found or something went wrong.");
		return false;
	}

	@Override
	public ArrayList<ContractBean> showAllContract() {
		return cblist;
	}
}
