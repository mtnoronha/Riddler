package com.sifionsolution.codex.model.dao;

import static org.joda.time.DateTime.now;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sifionsolution.codex.dao.GenericDAO;
import com.sifionsolution.codex.dao.parameters.HqlParameter;
import com.sifionsolution.codex.model.Riddle;
import com.sifionsolution.codex.model.RiddleTest;
import com.sifionsolution.codex.model.RiddleTestAnswer;
import com.sifionsolution.codex.model.User;
import com.sifionsolution.codex.security.UserWeb;

@RequestScoped
public class RiddleTestDAO {

	private final GenericDAO<Long, RiddleTest> dao;
	private final GenericDAO<Long, RiddleTestAnswer> answerDao;

	private final UserWeb userWeb;
	private final UserDAO userDao;

	private static final Logger logger = LoggerFactory.getLogger(RiddleTestDAO.class);

	/*
	 * CDI eyes only
	 */
	@Deprecated
	public RiddleTestDAO() {
		this(null, null, null);
	}

	@Inject
	public RiddleTestDAO(EntityManager manager, UserWeb userWeb, UserDAO userDao) {
		this.userWeb = userWeb;
		this.userDao = userDao;
		dao = new GenericDAO<Long, RiddleTest>(RiddleTest.class, manager);
		answerDao = new GenericDAO<Long, RiddleTestAnswer>(RiddleTestAnswer.class, manager);

	}

	@SuppressWarnings("unchecked")
	public List<RiddleTest> getCompletedTestsFor(Riddle riddle) {
		return (List<RiddleTest>) dao.listByHql(
				"Select rt from RiddleTest rt where rt.end is not null AND rt.riddle = :riddle", new HqlParameter(
						"riddle", riddle));
	}

	@SuppressWarnings("unchecked")
	public RiddleTest getCurrentTest() {
		List<RiddleTest> list = (List<RiddleTest>) dao.listByHql(
				"Select rt from RiddleTest rt where rt.end is null AND rt.user.username = :user", new HqlParameter(
						"user", userWeb.getUsername()));

		if (list.isEmpty())
			return null;

		if (list.size() > 1)
			logger.error("There are more than one test opened for user: " + userWeb.getUsername());

		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public RiddleTest getNextTest() {
		List<Riddle> list = (List<Riddle>) dao
				.listByHql(
						"Select r from Riddle r where not exists (select rt.riddle from RiddleTest rt where rt.riddle = r and rt.user.username = :user) order by r.level",
						new HqlParameter("user", userWeb.getUsername()));

		if (list.isEmpty())
			return null;

		return createRiddleTest(list.get(0));

	}

	public boolean doesTestBelongToUser(RiddleTest test) {
		return test.getUser().getId().equals(getUser().getId());
	}

	private RiddleTest createRiddleTest(Riddle riddle) {
		RiddleTest test = new RiddleTest(null, now(), null, null, null, riddle, getUser(), null);
		dao.save(test);
		return test;
	}

	private User getUser() {
		return userDao.getBy(userWeb);
	}

	public void save(RiddleTestAnswer entity) {
		answerDao.save(entity);
	}

	public void update(RiddleTest test) {
		dao.update(test);
	}

	public RiddleTest find(Long id) {
		return dao.getById(id);
	}

}
