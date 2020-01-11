package com.capg.retailermanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capg.retailermaintanance.dto.Userinfo;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceUnit
	EntityManagerFactory factory;
	
	@Override
	public boolean addUser(Userinfo ubean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(ubean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	@Override
	public List<Userinfo> getAllUsers() {
		EntityManager manager = factory.createEntityManager();
		String getall="from userinfo";
		TypedQuery<Userinfo> query=manager.createQuery(getall,Userinfo.class);
		return query.getResultList();
	}


	@Override
	public Userinfo login(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		Userinfo user=manager.find(Userinfo.class, email);
		return user;
	

	}
	

}
