package com.capgemini.loanprocessingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dao.CustomerDAO;
import com.capgemini.loanprocessingsystem.dao.CustomerDAOImpl;
import com.capgemini.loanprocessingsystem.dto.Customers;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;
@SpringBootTest
class CustomerServiceImplTest {
	@Autowired
	CustomerService customerDAO = new CustomerServiceImpl();
	Customers customers;

	@Test
	void testGetAllCustomers() {
		try { 
			List<Customers> check =
			customerDAO.getAllCustomers(); assertEquals(check!=null, true);

	}catch (Exception e) { assertThrows(CustomException.class, ()->{
		customerDAO.getAllCustomers();
		}); 
	}	}

	@Test
	void testInsertCustomer() {
		customers = new Customers();
		customers.setCustomerName("Rita");
		customers.setGender("Male");
		customers.setDateOfBirth("12/10/1994");
		customers.setEmail("rita@gmail.com");
		customers.setAddress("bangalore");
	customers.setAnnualIncome(25.00);
		customers.setOccupation("business");
		customers.setAadharNumber("123789456753");
		customers.setNominee("kelvin");
	customers.setPhoneNumber("7539154568");
		customers.setLoanType("renovation");
		customers.setPincode(789456);
		customers.setPropertyDetails("123-rs-dwarka");
		customers.setState("karnataka");
		customers.setTown("karkal");
		boolean flag = customerDAO.insertCustomer(customers);
		try {
			assertEquals(flag, true);
			
		}catch (Exception e) {
			assertThrows(CustomException.class, ()->{
				customerDAO.insertCustomer(customers);
			});
	}
		}
}
