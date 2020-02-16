package com.capgemini.loanprocessingsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dto.Customers;
import com.capgemini.loanprocessingsystem.dto.FinanceProviderBean;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@SpringBootTest
class FinanceProviderDAOImplTest {

	
	  @Autowired FinanceProviderDAO financeProviderDAO = new
	 FinanceProviderDAOImpl(); 
	  FinanceProviderBean financeProviderBean;
	 
//	 @Test void testAddFinance() { 
//	 financeProviderBean= new FinanceProviderBean();
//	 financeProviderBean.setLoanType("Renovation");
//	 financeProviderBean.setLoanTerm(5);
//	 financeProviderBean.setInterest(5.0);
//	 financeProviderBean.setLoanAmount(3); 
//	 boolean flag =financeProviderDAO.addFinance(financeProviderBean); 
//	 try { assertEquals(flag,true); 
//	 }catch (Exception e) {
//		 assertThrows(CustomException.class, ()->{
//	  financeProviderDAO.addFinance(financeProviderBean); 
//	  }); 
//		} 
//	 
//	  }
	  
	  
	  
	  
	  
//	  @Test void testDeleteFinance() { 
//	  boolean check = financeProviderDAO.deleteFinance("purchase"); 
//	  assertEquals(check, false);
//	  
//	  }
	 
	
	
	 @Test void testGetAllFinance() { 
		 try { 
				List<FinanceProviderBean> check =
						financeProviderDAO.getAllFinance();
				assertEquals(check!=null, true);

		}catch (Exception e) { assertThrows(CustomException.class, ()->{
			financeProviderDAO.getAllFinance();
			}); 
		}
	 }
}
