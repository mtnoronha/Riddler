package com.sifionsolution.codex.google.charts;

import java.util.List;

public class ChartWrapper {

	private final List<ChartColumn> cols;
	private final List<ChartRow> rows;

	public ChartWrapper(List<ChartColumn> cols, List<ChartRow> rows) {
		this.cols = cols;
		this.rows = rows;
	}

	public List<ChartColumn> getCols() {
		return cols;
	}

	public List<ChartRow> getRows() {
		return rows;
	}

}
