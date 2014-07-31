package com.sifionsolution.riddler.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.sifionsolution.riddler.dao.parameters.HqlParameter;

public class GenericDAO<PK, T> {

	private final EntityManager entityManager;
	private final Class<?> clazz;

	public GenericDAO(Class<?> clazz, EntityManager entityManager) {
		this.clazz = clazz;
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public T getById(PK pk) {
		return (T) entityManager.find(clazz, pk);
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + clazz.getName())).getResultList();
	}

	public List<?> listByHql(String hql, HqlParameter... params) {
		Query query = entityManager.createQuery(hql);

		for (HqlParameter param : params)
			param.apply(query);

		return query.getResultList();
	}

	public Object uniqueResultByHql(String hql, HqlParameter... params) {
		Query query = entityManager.createQuery(hql);

		for (HqlParameter param : params)
			param.apply(query);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
