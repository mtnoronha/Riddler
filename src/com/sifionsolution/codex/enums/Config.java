package com.sifionsolution.codex.enums;

import static java.lang.String.format;

public enum Config {
	DATABASE("database.properties");

	private static final String ROOT = "/config/%s";
	private String file;

	private Config(String file) {
		this.file = file;
	}

	public String getPath() {
		return format(ROOT, file);
	}
}
