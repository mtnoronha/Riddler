package com.sifionsolution.riddler.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import br.com.caelum.vraptor.security.Permission;
import br.com.caelum.vraptor.security.User;

import com.sifionsolution.riddler.enums.Role;
import com.sifionsolution.riddler.model.dao.UserDAO;

public class ShiroSecurityIntegration implements Permission {

	@Inject
	private UserDAO dao;

	@Override
	public Set<String> getPermissionsByRole(String role) {
		return new HashSet<String>();
	}

	@Override
	public Set<String> getRolesByUser(String username) {
		return toStringSet(dao.getRoles(username));
	}

	@Override
	public User getUserByUsername(String username) {
		User shiroUser = new User(username, dao.getPassword(username));
		return shiroUser;
	}

	private Set<String> toStringSet(List<Role> roles) {
		return null;
	}
}
