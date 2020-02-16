package com.capgemini.loanprocessingsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.security.auth.login.LoginException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.dto.LoginBean;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;

@Repository
public class LoginDAOImpl implements LoginDAO{

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public LoginBean auth(String email, String password) {
		EntityManager manager=factory.createEntityManager();
		String jpql="from LoginBean where email=:email";
		TypedQuery<LoginBean> query=manager.createQuery(jpql, LoginBean.class);
		query.setParameter("email", email);
		
		try {
			LoginBean bean=query.getSingleResult();
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			if(encoder.matches(password, bean.getPassword())){
				manager.close();
				return bean;
			}else {
				manager.close();
				throw new LoginException("Password Invalid");
			}
		} catch (Exception e) {
			manager.close();
			throw new CustomException("Invalid credentials... Please try again");
		}

	}

	@Override
	public boolean register(LoginBean bean) {
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Email already exist");
		}
	}

}
