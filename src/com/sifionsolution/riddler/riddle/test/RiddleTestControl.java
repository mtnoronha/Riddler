package com.sifionsolution.riddler.riddle.test;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.sifionsolution.riddler.model.RiddleTest;
import com.sifionsolution.riddler.model.dao.RiddleTestDAO;

@RequestScoped
public class RiddleTestControl {

	@Inject
	private RiddleTestDAO dao;

	private RiddleTest current;

	@PostConstruct
	public void init() {
		current = get();
	}

	public RiddleTest getCurrent() {
		return current;
	}

	private RiddleTest get() {
		RiddleTest current = dao.getCurrentTest();

		if (current == null)
			return dao.getNextTest();

		return current;
	}

}
