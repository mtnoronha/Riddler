package com.sifionsolution.riddler.model.dto;

public class SignInUser {
	private final String username;
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
