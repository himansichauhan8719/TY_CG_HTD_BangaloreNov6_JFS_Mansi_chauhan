package com.capgemini.loanprocessingsystem.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.CustomerDAO;
import com.capgemini.loanprocessingsystem.dto.Customers;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;
import com.capgemini.loanprocessingsystem.validations.Validations;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;
	@Override
	public List<Customers> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	public boolean insertCustomer(Customers customers) {


		if(!Validations.isChar(customers.getCustomerName())){
			throw new CustomException("Invalid name");
		}
		if( !Validations.isChar(customers.getGender())) {
			throw new CustomException("Invalid data1");
		}
		if(!Validations.aadhar(customers.getAadharNumber())) {
			throw new CustomException("Invalid data2");
		}
		if(!Validations.phone(customers.getPhoneNumber())) {
			throw new CustomException("Invalid data3");
		}
		if(!Validations.email(customers.getEmail())) {
			throw new CustomException("Invalid data4");
		}
		if(! Validations.validateTown(customers.getTown())) {
			throw new CustomException("Invalid data5");
		}

		if(!Validations.validatePostal(customers.getPincode())) {
			throw new CustomException("Invalid data6");
		}
		if(! Validations.isChar(customers.getState())) {
			throw new CustomException("Invalid data7");
		}
		
		if( ! Validations.isChar(customers.getOccupation())) {
			throw new CustomException("Invalid data8");
		}
		
		if( ! Validations.address(customers.getPropertyDetails())) {
			throw new CustomException("Invalid data10");
		}
		if(! Validations.isChar(customers.getNominee())) {
			throw new CustomException("Invalid data11");
		}
		
		return customerDAO.insertCustomer(customers);


		

	}

	@Override
	public Customers searchCustomers(int applicationId) {
		if(!Validations.isNumber(applicationId)) {
			throw new CustomException("Invalid data"); 	
		}
		return customerDAO.searchCustomers(applicationId);
	}

}
