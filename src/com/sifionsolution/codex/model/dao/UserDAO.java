package com.sifionsolution.codex.model.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sifionsolution.codex.dao.GenericDAO;
import com.sifionsolution.codex.dao.parameters.HqlParameter;
import com.sifionsolution.codex.model.User;
import com.sifionsolution.codex.model.dto.SignInUser;
import com.sifionsolution.codex.model.dto.SignUpUser;
import com.sifionsolution.codex.security.UserWeb;

@RequestScoped
public class UserDAO {

	private final GenericDAO<Long, User> dao;

	/*
	 * CDI eyes only
	 */
	@Deprecated
	public UserDAO() {
		this(null);
	}

	@Inject
	public UserDAO(EntityManager manager) {
		dao = new GenericDAO<Long, User>(User.class, manager);
	}

	public void register(SignUpUser dto) {
		User user = new User();
		// FIXME encrypt it!
		String encrypted = dto.getPassword();

		user.load(dto, encrypted);

		dao.save(user);
	}

	public User login(SignInUser user) {
		return (User) dao
				.uniqueResultByHql(
						"select u from User u where (u.username = :username OR u.email = :username) AND u.password = :password",
						new HqlParameter("username", user.getUsername()),
						new HqlParameter("password", user.getPassword()));
	}

	public User getBy(UserWeb userWeb) {
		return (User) dao.uniqueResultByHql(
				"select u from User u where (u.username = :username OR u.email = :username)", new HqlParameter(
						"username", userWeb.getUsername()));

	}
}