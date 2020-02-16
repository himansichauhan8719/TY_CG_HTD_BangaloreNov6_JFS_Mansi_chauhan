package com.capgemini.loanprocessingsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dto.Customers;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@SpringBootTest
class CustomerDAOImplTest {
	@Autowired
	CustomerDAO customerDAO = new CustomerDAOImpl();
	Customers customers;


	@Test void testGetAllCustomers() { 
		try { 
			List<Customers> check =
			customerDAO.getAllCustomers(); assertEquals(check!=null, true);

	}catch (Exception e) { assertThrows(CustomException.class, ()->{
		customerDAO.getAllCustomers();
		}); 
	}
		}


		@Test
		void testInsertCustomer() {
			customers = new Customers();
			customers.setCustomerName("John");
			customers.setGender("Male");
			customers.setDateOfBirth("1995-01-12");
			customers.setEmail("john@gmail.com");
			customers.setAddress("bangalore");
		customers.setAnnualIncome(2.00);
			customers.setOccupation("teacher");
			customers.setAadharNumber("123789456753");
			customers.setNominee("kelvin");
		customers.setPhoneNumber("7539154568");
			customers.setLoanType("ronovation");
			customers.setPincode(789456);
			customers.setPropertyDetails("#345, bangalore");
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

	@Test
	void testSearchCustomers() {
		customers =customerDAO.searchCustomers(33);
		assertEquals(customers, true);

	}

}
