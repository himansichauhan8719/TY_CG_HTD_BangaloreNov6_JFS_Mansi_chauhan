package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.loanprocessingsystem.dto.Customers;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;


	@Override
	public List<Customers> getAllCustomers() {
		EntityManager manager = factory.createEntityManager();
		String getall="from Customers";
		TypedQuery<Customers> query=manager.createQuery(getall,Customers.class);
		return query.getResultList();
	}

	@Override
	public boolean insertCustomer(Customers customers) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(customers);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Customers searchCustomers(int applicationId) {
		try {
			EntityManager entityManager = factory.createEntityManager();
			Customers customers = entityManager.find(Customers.class, applicationId);
			if(customers!=null) {
				return customers;
			}else {
				return null;
			}
		}catch (Exception e) {
			String message = e.getMessage();
			System.out.println("ApplicationId not available "+message);
		}return null;
	}
	}

