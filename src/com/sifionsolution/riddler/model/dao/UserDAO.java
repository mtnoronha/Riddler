package com.sifionsolution.riddler.model.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.shiro.authc.credential.PasswordService;

import com.sifionsolution.riddler.dao.GenericDAO;
import com.sifionsolution.riddler.dao.parameters.HqlParameter;
import com.sifionsolution.riddler.enums.Role;
import com.sifionsolution.riddler.model.User;

@RequestScoped
public class UserDAO {

	private final GenericDAO<Long, User> dao;
	private final PasswordService passwordService;

	/*
	 * CDI eyes only
	 */
	@Deprecated
	public UserDAO() {
		this(null, null);
	}

	@Inject
	public UserDAO(EntityManager manager, PasswordService passwordService) {
		this.passwordService = passwordService;
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

	public void save() {
		// TODO remember to get password and call:
		passwordService.encryptPassword("pass");

	}
}
