package com.sifionsolution.riddler.model.dto;

import javax.validation.constraints.NotNull;

public class SignUpUser {
	@NotNull
	private final String name;

	@NotNull
	private final String username;

	@NotNull
	private final String email;

	@NotNull
	private final String password;

	public SignUpUser(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

}
