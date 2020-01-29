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
	
	public void delete(O object) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(object);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public void deletePorId(O object) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = JPAUtil.getPrimaryKey(object);
		
		/*entityManager.createQuery("DELETE FROM :entity WHERE id = :id").
			setParameter("entity", object.getClass().getCanonicalName()).
			setParameter("id", JPAUtil.getPrimaryKey(object)).executeUpdate(); */
		
		entityManager.createQuery("DELETE FROM " + object.getClass().getCanonicalName() +" WHERE id = " + id).
		 	executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
	}
}
