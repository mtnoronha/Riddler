package com.sifionsolution.codex.analysis.charts.builder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import com.sifionsolution.codex.google.charts.ChartCell;
import com.sifionsolution.codex.google.charts.ChartColumn;
import com.sifionsolution.codex.google.charts.ChartWrapper;
import com.sifionsolution.codex.google.charts.builder.ChartBuilder;

@RequestScoped
public class OverallChartBuilder {

	private ChartBuilder chartBuilder;
	private Integer total;
	private Integer feedbacks;
	private Integer solved;
	private Integer gaveups;

	public OverallChartBuilder numberOfTests(Integer value) {
		total = value;
		return this;
	}

	public OverallChartBuilder withFeedbacks(Integer value) {
		feedbacks = value;
		return this;
	}

	public OverallChartBuilder wasSolved(Integer value) {
		solved = value;
		return this;
	}

	public OverallChartBuilder wasGivinUp(Integer value) {
		gaveups = value;
		return this;
	}

	@PostConstruct
	public void init() {
		chartBuilder = new ChartBuilder();

		chartBuilder.addColumn(new ChartColumn("", "Description", "", "string"));
		chartBuilder.addColumn(new ChartColumn("", "Quantity", "", "number"));

	}

	public ChartWrapper build() {
		chartBuilder.addRow(new ChartCell("Total", null), new ChartCell(total, null));

		chartBuilder.addRow(new ChartCell("With feedback", null), new ChartCell(feedbacks, null));
		chartBuilder.addRow(new ChartCell("Solved", null), new ChartCell(solved, null));
		chartBuilder.addRow(new ChartCell("Gaviups", null), new ChartCell(gaveups, null));

		return chartBuilder.build();
	}
}
