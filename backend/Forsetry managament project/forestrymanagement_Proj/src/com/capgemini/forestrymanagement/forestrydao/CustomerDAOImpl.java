package com.capgemini.forestrymanagement.forestrydao;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.forestrybean.CustomerBean;

public class CustomerDAOImpl implements CustomerDAO{
	private ArrayList<CustomerBean> cblist = new ArrayList<CustomerBean>();
	@Override
	public boolean addCustomer(CustomerBean cbean) {
		for(CustomerBean customerbean :cblist) {
			if(customerbean.getCustomerId() == cbean.getCustomerId()) {
				System.out.println("Customer with Same id already exists..!!!");
				return false;	
			}
		}
		cblist.add(cbean);
		System.out.println("Customer Added Successfully..");
		return true;
	}

	@Override
	public boolean modifyCustomer(CustomerBean custBean) {
		CustomerBean bean=getCustomer(custBean.getCustomerId());	
		if(bean!=null) {
			for (CustomerBean customerBean : cblist) {
				if(customerBean.getCustomerId()==bean.getCustomerId()) {
					cblist.remove(customerBean);
				}
			}
			bean.setCustomerName(custBean.getCustomerName());
			bean.setEmail(custBean.getEmail());
			bean.setPostalcode(custBean.getPostalcode());
			bean.setStreetAdd1(custBean.getStreetAdd1());
			bean.setStreetAdd2(custBean.getStreetAdd2());
			bean.setTelephoneNo(custBean.getTelephoneNo());
			bean.setTown(custBean.getTown());
			cblist.add(bean);
			System.out.println("record updated successfully...");
		}else {
			System.out.println("Either Customer not found or something went wrong.");
		}
		return false;
	}

	@Override
	public CustomerBean getCustomer(int id) {
		for (CustomerBean customerBean : cblist) {
			if(customerBean.getCustomerId()==id) {
				return customerBean;
			}
		}
		return null;
	}
	@Override
	public boolean deleteCustomer(int customerId) {
			CustomerBean bean = null;
			for(CustomerBean customerbean : cblist) {
				if(customerbean.getCustomerId()==customerId) {
					bean =customerbean;
				}
			}
			if(bean!=null) {
				cblist.remove(bean);
				System.out.println("Customer removed Successfully..");
				return true;
			}
			System.out.println("Either Customer not found or something went wrong.");
			return false;
		}

	@Override
	public ArrayList<CustomerBean> showAllCustomer() {
		return cblist;
	}
}