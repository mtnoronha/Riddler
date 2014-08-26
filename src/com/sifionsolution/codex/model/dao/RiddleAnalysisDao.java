package com.sifionsolution.codex.model.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.sifionsolution.codex.model.Riddle;
import com.sifionsolution.codex.model.RiddleTest;

@RequestScoped
public class RiddleAnalysisDao {

	@Inject
	private RiddleDAO riddleDao;

	@Inject
	private RiddleTestDAO riddleTestDao;

	public List<Riddle> listRiddles() {
		return riddleDao.list();
	}

	public List<RiddleTest> testsFor(Riddle riddle) {
		return riddleTestDao.getCompletedTestsFor(riddle);
	}

}
