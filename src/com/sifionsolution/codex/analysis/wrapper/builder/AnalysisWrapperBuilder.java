package com.sifionsolution.codex.analysis.wrapper.builder;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.sifionsolution.codex.analysis.charts.builder.OverallChartBuilder;
import com.sifionsolution.codex.analysis.charts.builder.TimeChartBuilder;
import com.sifionsolution.codex.google.charts.ChartWrapper;
import com.sifionsolution.codex.model.RiddleTest;
import com.sifionsolution.codex.riddle.test.analysis.AnalysisWrapper;

@RequestScoped
public class AnalysisWrapperBuilder {

	@Inject
	private TimeChartBuilder timeChartBuilder;

	@Inject
	private OverallChartBuilder overallChartBuilder;

	public AnalysisWrapper build(List<RiddleTest> tests) {

		Integer total = tests.size();
		Integer feedbacks = 0;
		Integer solved = 0;
		Integer gaveups = 0;

		timeChartBuilder.withTotal(total);

		for (RiddleTest test : tests) {
			timeChartBuilder.compute(test);

			if (test.getComment() != null)
				feedbacks++;

			if (test.getSolved() == true)
				solved++;
			else
				gaveups++;
		}

		// Creating charts
		ChartWrapper overall = overallChartBuilder.numberOfTests(total).withFeedbacks(feedbacks).wasSolved(solved)
				.wasGivinUp(gaveups).build();

		ChartWrapper time = timeChartBuilder.build();

		return new AnalysisWrapper(overall, time);
	}

}
