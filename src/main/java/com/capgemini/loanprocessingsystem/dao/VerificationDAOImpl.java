package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.loanprocessingsystem.dto.Verification;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@Repository
public class VerificationDAOImpl implements VerificationDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public List<Verification> getAllVerification() {
		EntityManager manager = factory.createEntityManager();
		String getall="from Verification";
		TypedQuery<Verification> query=manager.createQuery(getall,Verification.class);
		return query.getResultList();
		
	}

	@Override
	public boolean insertVerification(Verification verification) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(verification);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteVerification(int verificationId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Verification verification = manager.find(Verification.class, verificationId);
		if(verification!=null) {
			transaction.begin();
			manager.remove(verification);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Verification searchVerification(int applicationId) {
			try
			{
			EntityManager entityManager= factory.createEntityManager();
			Verification searchVerification=entityManager.find(Verification.class, applicationId);
			return searchVerification;
		} catch(Exception e)
			{
			throw new CustomException("Id does not exist");
			}
		}

	@Override
	public boolean modifyVerification(int verificationId, int applicationId, String interviewDate, String status,
			String loanType) {
			EntityManager entityManager= null;
			EntityTransaction transaction=null;
			try
			{
			entityManager=factory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			Verification verification=entityManager.find(Verification.class, verificationId);
			verification.setInterviewDate(interviewDate);
			verification.setStatus(status);
			verification.setLoanType( loanType);
			transaction.commit();
			return true;
			}
			catch(Exception e)
			{
				transaction.rollback();
			}
			entityManager.close();
			throw new CustomException("Id does not exist,Cannot be modidfied");
		}
		
	}
	
