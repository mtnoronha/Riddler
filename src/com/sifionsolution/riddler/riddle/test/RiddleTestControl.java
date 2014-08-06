package com.sifionsolution.riddler.riddle.test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.sifionsolution.riddler.model.Riddle;
import com.sifionsolution.riddler.model.dao.RiddleTestDAO;

@RequestScoped
public class RiddleTestControl {

	@Inject
	private RiddleTestDAO dao;

	public Riddle get() {
		Riddle current = dao.getCurrentTest();

		if (current == null)
			return dao.getNextTest();
	}

}
