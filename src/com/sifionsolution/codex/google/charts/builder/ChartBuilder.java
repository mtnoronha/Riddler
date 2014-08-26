package com.sifionsolution.codex.google.charts.builder;

import java.util.ArrayList;
import java.util.List;

import com.sifionsolution.codex.google.charts.ChartCell;
import com.sifionsolution.codex.google.charts.ChartColumn;
import com.sifionsolution.codex.google.charts.ChartRow;
import com.sifionsolution.codex.google.charts.ChartWrapper;

public class ChartBuilder {

	private final List<ChartColumn> cols = new ArrayList<ChartColumn>();
	private final List<ChartRow> rows = new ArrayList<ChartRow>();

	public ChartBuilder addColumn(ChartColumn column) {
		cols.add(column);
		return this;
	}

	public ChartBuilder addRow(ChartCell... cells) {
		List<ChartCell> list = new ArrayList<ChartCell>();

		for (ChartCell cell : cells) {
			list.add(cell);
		}

		ChartRow row = new ChartRow(list);
		rows.add(row);

		return this;
	}

	public ChartWrapper build() {
		return new ChartWrapper(cols, rows);
	}
}
