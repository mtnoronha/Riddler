package com.sifionsolution.codex.model.wrapper;

import com.sifionsolution.codex.model.User;

public class UserWrapper {

	private String name;
	private String username;
	private String email;

	public UserWrapper(User user) {
		name = user.getName();
		username = user.getUsername();
		email = user.getEmail();
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

}
