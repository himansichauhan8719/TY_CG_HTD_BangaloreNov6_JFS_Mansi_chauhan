package com.capgemini.loanprocessingsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dto.Customers;
import com.capgemini.loanprocessingsystem.dto.Status;
import com.capgemini.loanprocessingsystem.dto.Verification;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@SpringBootTest
class VerificationDAOImplTest {
	@Autowired
	VerificationDAO verificationDAO = new VerificationDAOImpl();
	Verification verifications;

	@Test
	void testGetAllVerification() {
		try { 
			List<Verification> check =
			verificationDAO.getAllVerification(); 
			assertEquals(check!=null, true);

	}catch (Exception e) { 
		assertThrows(CustomException.class, ()->{
			verificationDAO.getAllVerification(); 
		}); 
	}	}

	@Test
	void testInsertVerification() {
		verifications = new Verification();
		verifications.setApplicationId(420);
		verifications.setInterviewDate("20/02/2020");
		verifications.setLoanType("Renovation");
		verifications.setStatus("Accepted");
		boolean flag = verificationDAO.insertVerification(verifications);
		try {
			assertEquals(flag, true);
			
		}catch (Exception e) {
			assertThrows(CustomException.class, ()->{
				verificationDAO.insertVerification(verifications);
			});
	}	}

	@Test
	void testDeleteVerification() {
	boolean check = verificationDAO.deleteVerification(40);
	assertEquals(check, true);	}

}
