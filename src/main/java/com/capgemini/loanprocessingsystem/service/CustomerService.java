package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import com.capgemini.loanprocessingsystem.dto.Customers;

public interface CustomerService {
	public List<Customers> getAllCustomers();
	public boolean insertCustomer(Customers customers);
	public Customers searchCustomers(int applicationId);


}
