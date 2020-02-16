package com.capgemini.loanprocessingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dao.FinanceProviderDAO;
import com.capgemini.loanprocessingsystem.dao.FinanceProviderDAOImpl;
import com.capgemini.loanprocessingsystem.dto.FinanceProviderBean;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;
@SpringBootTest
class FinanceProviderServicesImplTest {
	@Autowired FinanceProviderServices financeProviderDAO = new
			 FinanceProviderServicesImpl(); 
			  FinanceProviderBean financeProviderBean;
			 

	@Test
	void testAddFinance() {
		financeProviderBean= new FinanceProviderBean();
		 financeProviderBean.setLoanType("purchase");
		 financeProviderBean.setLoanTerm(9.8);
		 financeProviderBean.setInterest(7.3);
		 financeProviderBean.setLoanAmount(29.8); 
		 boolean flag =financeProviderDAO.addFinance(financeProviderBean); 
		 try { 
			 assertEquals(flag,true); 
		 }catch (Exception e) {
			 assertThrows(CustomException.class, ()->{
		  financeProviderDAO.addFinance(financeProviderBean); 
		  }); 
			} 
		 }

	@Test
	void testDeleteFinance() {
		 boolean check=financeProviderDAO.deleteFinance("purchase"); 
		  assertEquals(check, true);	
		  }
	@Test
	void testGetAllFinance() {
		try { 
			List<FinanceProviderBean> check =
					financeProviderDAO.getAllFinance();
			assertEquals(check!=null, true);

	}catch (Exception e) { assertThrows(CustomException.class, ()->{
		financeProviderDAO.getAllFinance();
		}); 
	}	}
}
