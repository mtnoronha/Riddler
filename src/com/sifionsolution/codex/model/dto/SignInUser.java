package com.sifionsolution.codex.model.dto;

import javax.validation.constraints.NotNull;

public class SignInUser {
	@NotNull(message = "{empty.username}")
	private final String username;

	@NotNull(message = "{empty.password}")
	private final String password;

	public SignInUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
