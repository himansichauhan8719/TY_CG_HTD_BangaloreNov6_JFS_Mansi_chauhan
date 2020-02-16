package com.capgemini.retailermentenance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.retailermentenance.dto.ProductInfo;
import com.capgemini.retailermentenance.exception.ProductExceptions;
import com.capgemini.retailermentenance.exception.UserExceptions;

@Repository
public class ProductDaoImpl implements ProductDao{

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public ProductInfo getProduct(int id) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		ProductInfo product= manager.find(ProductInfo.class, id);
		return product;
	}

	@Override
	public boolean addProduct(ProductInfo productInfo) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(productInfo);
			transaction.commit();
			return true;
		} catch (Exception e) {
		}
		throw new ProductExceptions("Duplicate Product Id Not Allowed");
	}
	
	
	
}
