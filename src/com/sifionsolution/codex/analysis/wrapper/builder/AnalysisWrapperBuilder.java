package com.sifionsolution.codex.analysis.wrapper.builder;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.sifionsolution.codex.google.charts.ChartCell;
import com.sifionsolution.codex.google.charts.ChartColumn;
import com.sifionsolution.codex.google.charts.builder.ChartBuilder;
import com.sifionsolution.codex.model.RiddleTest;
import com.sifionsolution.codex.riddle.test.analysis.AnalysisWrapper;

@RequestScoped
public class AnalysisWrapperBuilder {

	public AnalysisWrapper build(List<RiddleTest> tests) {
		ChartBuilder chartBuilder = new ChartBuilder();

		chartBuilder.addColumn(new ChartColumn("", "Description", "", "string"));
		chartBuilder.addColumn(new ChartColumn("", "Quantity", "", "number"));

		chartBuilder.addRow(new ChartCell("Total", null), new ChartCell(tests.size(), null));
		Integer feedbacks = 0;
		Integer solved = 0;
		Integer gaviups = 0;

		for (RiddleTest test : tests) {
			if (test.getComment() != null)
				feedbacks++;

			if (test.getSolved() == true)
				solved++;
			else
				gaviups++;
		}

		chartBuilder.addRow(new ChartCell("Solved", null), new ChartCell(solved, null));
		chartBuilder.addRow(new ChartCell("Gaviups", null), new ChartCell(gaviups, null));
		chartBuilder.addRow(new ChartCell("With feedback", null), new ChartCell(feedbacks, null));

		AnalysisWrapper wrapper = new AnalysisWrapper(chartBuilder.build());
		return wrapper;
	}

}
