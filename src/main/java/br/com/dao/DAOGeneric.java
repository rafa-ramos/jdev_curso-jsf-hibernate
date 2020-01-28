package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JPAUtil;

public class DAOGeneric<O> {
	
	public void save(O object) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(object);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public O merge(O object) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		O result = entityManager.merge(object);
		
		entityTransaction.commit();
		entityManager.close();
		
		return result;
	}
	
}
