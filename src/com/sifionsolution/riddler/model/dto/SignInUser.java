package com.sifionsolution.riddler.model.dto;

public class SignInUser {
	private final String username;
	private final String password;
	private final Boolean remember;

	public SignInUser(String username, String password, Boolean remember) {
		this.username = username;
		this.password = password;
		this.remember = remember;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getRemember() {
		return remember;
	}

}
