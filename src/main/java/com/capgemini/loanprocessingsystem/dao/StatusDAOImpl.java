package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.dto.Status;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@Repository
public class StatusDAOImpl implements StatusDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public List<Status> getAllStatus() {
		EntityManager manager = factory.createEntityManager();
		String getall = "from Status";
		TypedQuery<Status> query = manager.createQuery(getall, Status.class);
		return query.getResultList();
	}

	@Override
	public boolean insertStatus(Status status) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(status);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteStatus(int statusId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Status status = manager.find(Status.class, statusId);
		if (status != null) {
			transaction.begin();
			manager.remove(status);
			transaction.commit();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Status searchStatus(int statusId) {
		try {
			EntityManager entityManager = factory.createEntityManager();
			Status status = entityManager.find(Status.class, statusId);
			if (status != null) {
				return status;
			} else {
				return null;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println("StatusId not available " + message);
		}
		return null;
	}

	@Override
	public boolean modifyStatus(int statusId, int applicationId, String status, String loanType) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Status statuses = entityManager.find(Status.class, statusId);
			statuses.setLoanType(loanType);
			statuses.setStatus(status);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new CustomException("Id does not exist,Cannot be modidfied");
	}
}
