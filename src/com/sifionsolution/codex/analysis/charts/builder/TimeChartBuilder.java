package com.sifionsolution.codex.analysis.charts.builder;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.joda.time.Duration;

import com.sifionsolution.codex.google.charts.ChartCell;
import com.sifionsolution.codex.google.charts.ChartColumn;
import com.sifionsolution.codex.google.charts.ChartWrapper;
import com.sifionsolution.codex.google.charts.builder.ChartBuilder;
import com.sifionsolution.codex.model.RiddleTest;

@RequestScoped
public class TimeChartBuilder {

	private BigDecimal durationSum;
	private Integer total;
	private ChartBuilder chartBuilder;

	@PostConstruct
	public void init() {
		durationSum = new BigDecimal(0);
		chartBuilder = new ChartBuilder();

		chartBuilder.addColumn(new ChartColumn("", "User", "", "string"));
		chartBuilder.addColumn(new ChartColumn("", "Minutes", "", "number"));
	}

	public TimeChartBuilder withTotal(Integer total) {
		this.total = total;
		return this;
	}

	public void compute(RiddleTest test) {
		Duration duration = new Duration(test.getStart(), test.getEnd());
		durationSum = durationSum.add(new BigDecimal(duration.getMillis()));

		chartBuilder
				.addRow(new ChartCell(test.getUsername(), null), new ChartCell(duration.getStandardMinutes(), null));
	}

	public ChartWrapper build() {
		Integer avgTimeSpentMinutes = calculateAverageTimeSpent();

		chartBuilder.addRow(new ChartCell("Average", null), new ChartCell(avgTimeSpentMinutes, null));

		return chartBuilder.build();
	}

	private Integer calculateAverageTimeSpent() {
		long durationAvg = durationSum.divide(new BigDecimal(total)).longValue();
		return (int) TimeUnit.MILLISECONDS.toMinutes(durationAvg);
	}
}
