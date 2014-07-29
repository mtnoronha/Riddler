package com.sifionsolution.riddler.model.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sifionsolution.riddler.model.Teste;

@RequestScoped
public class TesteDAO {

	@Inject
	private EntityManager manager;

	public void save(Teste obj) {
		manager.persist(obj);
	}
}
