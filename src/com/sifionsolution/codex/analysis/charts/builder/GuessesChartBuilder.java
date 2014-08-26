package com.sifionsolution.codex.analysis.charts.builder;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import com.sifionsolution.codex.google.charts.ChartCell;
import com.sifionsolution.codex.google.charts.ChartColumn;
import com.sifionsolution.codex.google.charts.ChartWrapper;
import com.sifionsolution.codex.google.charts.builder.ChartBuilder;
import com.sifionsolution.codex.model.RiddleTest;

@RequestScoped
public class GuessesChartBuilder {

	private BigDecimal guessesSum;
	private Integer total;
	private ChartBuilder chartBuilder;

	@PostConstruct
	public void init() {
		guessesSum = new BigDecimal(0);
		chartBuilder = new ChartBuilder();

		chartBuilder.addColumn(new ChartColumn("", "User", "", "string"));
		chartBuilder.addColumn(new ChartColumn("", "Guesses", "", "number"));
	}

	public GuessesChartBuilder withTotal(Integer total) {
		this.total = total;
		return this;
	}

	public void compute(RiddleTest test) {
		Integer numberOfGuesses = test.numberOfAnswers();
		guessesSum = guessesSum.add(new BigDecimal(numberOfGuesses));

		// FIXME demeter law should be applied
		chartBuilder.addRow(new ChartCell(test.getUser().getUsername(), null), new ChartCell(numberOfGuesses, null));
	}

	public ChartWrapper build() {
		Integer avgGuesses = (int) guessesSum.divide(new BigDecimal(total)).longValue();

		chartBuilder.addRow(new ChartCell("Average", null), new ChartCell(avgGuesses, null));
		return chartBuilder.build();
	}
}
