package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import com.capgemini.loanprocessingsystem.dto.Customers;

public interface CustomerDAO {

	public List<Customers> getAllCustomers();
	public boolean insertCustomer(Customers customers);
	public Customers searchCustomers(int applicationId);


}
