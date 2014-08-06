package com.sifionsolution.riddler.security;

import static com.sifionsolution.commons.ContentVerifyer.notEmpty;
import static com.sifionsolution.riddler.enums.Role.LOGGED_IN;
import static com.sifionsolution.riddler.enums.Role.LOGGED_OFF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;

import com.sifionsolution.riddler.enums.Role;
import com.sifionsolution.riddler.model.User;

@SessionScoped
public class UserWeb implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String name;
	private List<Role> roles = Arrays.asList(LOGGED_OFF);

	public boolean isLoggedIn() {
		return containsAny(Arrays.asList(LOGGED_IN));
	}

	public boolean containsAny(List<Role> roles) {
		if (this.roles.equals(roles))
			return true;

		if (notEmpty(roles))
			for (Role role : roles)
				if (this.roles.contains(role))
					return true;

		return false;
	}

	public void signIn(User user) {
		if (user == null)
			throw new IllegalArgumentException("The obj cannot be null.");

		name = user.getName();
		username = user.getUsername();

		roles = new ArrayList<Role>();
		roles.add(LOGGED_IN);

		roles.addAll(user.getRoles());
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	@PreDestroy
	public void signOut() {
		username = "";
		name = "";
		roles = Arrays.asList(LOGGED_OFF);
	}

	public List<Role> getUserRoles() {
		return roles;
	}
}