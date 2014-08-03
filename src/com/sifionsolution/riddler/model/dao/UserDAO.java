package com.sifionsolution.riddler.model.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sifionsolution.riddler.dao.GenericDAO;
import com.sifionsolution.riddler.dao.parameters.HqlParameter;
import com.sifionsolution.riddler.model.User;
import com.sifionsolution.riddler.model.dto.SignInUser;
import com.sifionsolution.riddler.model.dto.SignUpUser;

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
}
