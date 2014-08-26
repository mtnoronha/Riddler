package com.sifionsolution.codex.google.charts;

public class ChartCell {

	// value
	private Object v;

	// formatted value
	private String f;

	public ChartCell(String v, String f) {
		this.v = v;
		this.f = f;
	}

	public ChartCell(Number v, String f) {
		this.v = v;
		this.f = f;
	}

	public Object getV() {
		return v;
	}

	public String getF() {
		return f;
	}

}
