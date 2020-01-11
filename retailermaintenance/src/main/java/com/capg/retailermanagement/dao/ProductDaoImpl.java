package com.capg.retailermanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capg.retailermaintanance.dto.Productinfo;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceUnit
	EntityManagerFactory factory;
	
	@Override
	public Productinfo getProduct(int proid) {
		
		EntityManager manager = factory.createEntityManager();
		Productinfo pro = manager.find(Productinfo.class, proid);
		return pro;
		
	}

}
