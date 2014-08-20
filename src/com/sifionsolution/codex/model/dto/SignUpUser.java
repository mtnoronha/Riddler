package com.sifionsolution.codex.model.dto;

import javax.validation.constraints.NotNull;

public class SignUpUser {
	@NotNull(message = "{empty.name}")
	private final String name;

	@NotNull(message = "{empty.username}")
	private final String username;

	@NotNull(message = "{empty.email}")
	private final String email;

	public SignUpUser(String name, String username, String email) {
		this.name = name;
		this.username = username;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

}
