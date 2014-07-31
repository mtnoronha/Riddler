package com.sifionsolution.riddler.model.dto;

import javax.validation.constraints.NotNull;

public class SignUpUser {
	@NotNull(message = "{empty.name}")
	private final String name;

	@NotNull(message = "{empty.username}")
	private final String username;

	@NotNull(message = "{empty.email}")
	private final String email;

	@NotNull(message = "{empty.password}")
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
