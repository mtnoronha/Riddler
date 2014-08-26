package com.sifionsolution.codex.google.charts;

public class ChartColumn {

	String id;
	String label;
	String pattern;
	String type;

	public ChartColumn(String id, String label, String pattern, String type) {
		this.id = id;
		this.label = label;
		this.pattern = pattern;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public String getPattern() {
		return pattern;
	}

	public String getType() {
		return type;
	}

}
