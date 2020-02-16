package com.capgemini.retailermentenance.dao;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Repository;

import com.capgemini.retailermentenance.dto.UserInfo;
import com.capgemini.retailermentenance.exception.UserExceptions;
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addUser(UserInfo userInfo) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(userInfo);
			transaction.commit();
			return true;
		} catch (Exception e) {
		}
		throw new UserExceptions("Duplicate user Id Not Allowed");
	
	}

	@Override
	public UserInfo loginUser(UserInfo userInfo) {
			EntityManager manager = entityManagerFactory.createEntityManager();
			String jpql = "from UserInfo where email=:email";
			TypedQuery<UserInfo> query = manager.createQuery(jpql, UserInfo.class);
			query.setParameter("email", userInfo.getEmail());
			try {
				UserInfo account = query.getSingleResult();
				if (account.getPassword().equals(userInfo.getPassword())) {
					return account;
				} 
			} catch (Exception e) {
			}
			throw new UserExceptions("Account does not exist");
		}

	@Override
	public boolean updatePassword(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update UserInfo set password = :psd where email = :email ";
		TypedQuery<UserInfo> query =  (TypedQuery<UserInfo>) entityManager.createQuery(jpql);
		query.setParameter("psd", password);
		query.setParameter("email", email);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
			throw new UserExceptions("Password Cannot be Changed");
		}

}
