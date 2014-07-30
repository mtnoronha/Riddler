package com.sifionsolution.riddler.enums;

public enum Role {
	USER("User"), ADMIN("Admin");

	private String role;

	private Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}