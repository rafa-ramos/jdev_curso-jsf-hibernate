package br.com.dao;

import java.util.List;

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
		
		entityManager.remove(entityManager.getReference(object.getClass(), JPAUtil.getPrimaryKey(object)));
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public List<O> getList(Class<O> object) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		@SuppressWarnings("unchecked")
		List<O> result = entityManager.createQuery("FROM " + object.getName()).
				getResultList();

		entityTransaction.commit();
		entityManager.close();
		
		return result;
	}
}
