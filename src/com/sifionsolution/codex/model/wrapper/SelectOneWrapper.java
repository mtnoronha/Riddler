package com.sifionsolution.codex.model.wrapper;

public class SelectOneWrapper {

	private final String value;
	private final String label;

	public SelectOneWrapper(String value, String label) {
		this.value = value;
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public final String getLabel() {
		return label;
	}

}
