package com.capgemini.loanprocessingsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dto.FinanceProviderBean;
import com.capgemini.loanprocessingsystem.dto.Status;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@SpringBootTest
class StatusDAOImplTest {
	@Autowired 
	StatusDAO statusDAO = new StatusDAOImpl();
	Status status ;

	@Test
	void testGetAllStatus() {
		 try { 
				List<Status> check =
						statusDAO.getAllStatus();
				assertEquals(check!=null, true);

		}catch (Exception e) { assertThrows(CustomException.class, ()->{
			statusDAO.getAllStatus();
			}); 
		}
	}

	@Test
	void testInsertStatus() {
		status = new Status();
		status.setApplicationId(33);
		status.setLoanType("Renovation");
		status.setStatus("approved");
		boolean check = statusDAO.insertStatus(status);
		try {
			assertEquals(check, true);
		}catch (Exception e) {
			assertThrows(CustomException.class, ()->{
				statusDAO.insertStatus(status);
			});
	}
	}

	@Test
	void testDeleteStatus() {
		boolean check = statusDAO.deleteStatus(14);
		assertEquals(check, true);
	}

	@Test
	void testSearchStatus() {
		status = new Status();
		int statusId = 34;
		try {
			Status check = statusDAO.searchStatus(statusId);
			assertEquals(check, true);
		}catch (Exception e) {
			assertThrows(CustomException.class, ()->{
				statusDAO.searchStatus(statusId);
			});
		}
	}

	@Test
	void testModifyStatus() {
		int statusId = 14;
		int applicationId = 10;
		String loanType = "construction";
		String status = "approved";
		try {
			boolean check =  statusDAO.modifyStatus(statusId, applicationId, status, loanType);
			assertEquals(check, true);
		}catch (Exception e) {
			assertThrows(CustomException.class, ()->{
				statusDAO.modifyStatus(statusId, applicationId, status, loanType);
			
		});
		}
		
	}

}
