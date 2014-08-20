package com.sifionsolution.codex.model.dto;

import javax.validation.constraints.NotNull;

public class SignInUser {
	@NotNull(message = "{empty.username}")
	private final String username;

	public SignInUser(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

}
