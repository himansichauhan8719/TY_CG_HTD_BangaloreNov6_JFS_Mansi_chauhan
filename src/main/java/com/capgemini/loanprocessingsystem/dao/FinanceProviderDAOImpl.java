package com.capgemini.loanprocessingsystem.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.dto.FinanceProviderBean;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;


@Repository
public class FinanceProviderDAOImpl implements FinanceProviderDAO{

	@PersistenceUnit
	EntityManagerFactory entitymanagerfact;
	
	@Override
	public boolean addFinance(FinanceProviderBean financebean) {
		EntityManager entitymanager = entitymanagerfact.createEntityManager();
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		try { 
			entitymanager.persist(financebean);
			transaction.commit();
			return true;
		  }catch ( Exception e) {
			 transaction.rollback();
		}
		entitymanager.close();
		throw new CustomException(" Can not be added duplicate Loan type is not allowed ");
	
	}

	@Override
	public boolean deleteFinance(String loanType) {
		EntityManager entityManager = entitymanagerfact.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from FinanceProviderBean where loanType = :loantype ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("loantype", loanType);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println(" This Loan Type is Delete Successfully :)");
			return true;
		}
		throw new CustomException("Can not be deleted loanType is worng :)");

	}


	@Override
	public boolean modifyFinance(String loanType , FinanceProviderBean financebean) {
		EntityManager entityManager = entitymanagerfact.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		FinanceProviderBean financeprovider = entityManager.find(FinanceProviderBean.class, loanType);
		if(financeprovider != null) {
			financeprovider.setLoanTerm(financebean.getLoanTerm());
			financeprovider.setLoanAmount(financebean.getLoanAmount());
			financeprovider.setInterest((financebean.getInterest()));
			transaction.commit();
		
			entityManager.close();
			return true;
		}
		entityManager.close();
		throw new CustomException("This Loan Type Cannot be Modified enter The Valid Loan Type :)");

	}

	@Override
	public ArrayList<FinanceProviderBean> getAllFinance() {
		
		EntityManager entityManager = entitymanagerfact.createEntityManager();
		String jpql = "from FinanceProviderBean ";
		Query query = entityManager.createQuery(jpql, FinanceProviderBean.class);
		ArrayList<FinanceProviderBean> financePro = (ArrayList<FinanceProviderBean>) query.getResultList();
			if (financePro != null && financePro.size()!=0) {
				return financePro;

			}
		throw new CustomException("Finance Provider Details Are not Present ");
	}

	@Override
	public FinanceProviderBean getFinance(String loanType) {
		FinanceProviderBean financepro = null;
		EntityManager entityManager = entitymanagerfact.createEntityManager();
		financepro = entityManager.find(FinanceProviderBean.class, loanType);
		if (financepro != null) {
			return financepro;

		}
		throw new CustomException("Finance Cannot be Found enter The Valid data");
	}

}
