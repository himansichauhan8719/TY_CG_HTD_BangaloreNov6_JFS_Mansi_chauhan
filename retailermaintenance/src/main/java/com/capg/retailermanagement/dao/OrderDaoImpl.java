package com.capg.retailermanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capg.retailermaintanance.dto.Orderinfo;
@Repository
public class OrderDaoImpl implements OrderDao {
	@PersistenceUnit
	EntityManagerFactory factory;
	
	@Override
	public Orderinfo getOrder(int orderid) {
		EntityManager manager = factory.createEntityManager();
		Orderinfo order = manager.find(Orderinfo.class, orderid);
		return order;
		
	}

}
