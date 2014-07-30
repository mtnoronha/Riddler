package com.sifionsolution.riddler.model.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sifionsolution.riddler.dao.GenericDAO;
import com.sifionsolution.riddler.dao.parameters.HqlParameter;
import com.sifionsolution.riddler.enums.Role;
import com.sifionsolution.riddler.model.User;

public class UserDAO {

	private final GenericDAO<Long, User> dao;

	@Inject
	public UserDAO(EntityManager manager) {
		dao = new GenericDAO<Long, User>(User.class, manager);
	}

	@SuppressWarnings("unchecked")
	public List<Role> getRoles(String username) {
		return (List<Role>) dao.listByHql("Select u.roles from User u where u.username = :username", new HqlParameter(
				"username", username));
	}

	public String getPassword(String username) {
		return (String) dao.uniqueResultByHql("Select u.password from User u where u.username = :username",
				new HqlParameter("username", username));
	}

}
