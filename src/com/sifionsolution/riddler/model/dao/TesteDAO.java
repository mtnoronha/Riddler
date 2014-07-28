package com.sifionsolution.riddler.model.dao;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sifionsolution.riddler.model.Teste;

@RequestScoped
public class TesteDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Teste obj) {
		manager.persist(obj);
	}
}
