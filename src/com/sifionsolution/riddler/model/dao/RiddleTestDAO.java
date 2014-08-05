package com.sifionsolution.riddler.model.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sifionsolution.riddler.dao.GenericDAO;
import com.sifionsolution.riddler.model.RiddleTest;

@RequestScoped
public class RiddleTestDAO {

	private final GenericDAO<Long, RiddleTest> dao;

	/*
	 * CDI eyes only
	 */
	@Deprecated
	public RiddleTestDAO() {
		this(null);
	}

	@Inject
	public RiddleTestDAO(EntityManager manager) {
		dao = new GenericDAO<Long, RiddleTest>(RiddleTest.class, manager);
	}
}
