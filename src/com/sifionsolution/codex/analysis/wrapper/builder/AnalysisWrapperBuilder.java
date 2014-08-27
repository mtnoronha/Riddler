package com.sifionsolution.codex.analysis.wrapper.builder;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.sifionsolution.codex.analysis.AnswerAnalysisBuilder;
import com.sifionsolution.codex.analysis.charts.builder.GuessesChartBuilder;
import com.sifionsolution.codex.analysis.charts.builder.OverallChartBuilder;
import com.sifionsolution.codex.analysis.charts.builder.TimeChartBuilder;
import com.sifionsolution.codex.analysis.wrapper.AnswerAnalysisWrapper;
import com.sifionsolution.codex.google.charts.ChartWrapper;
import com.sifionsolution.codex.model.RiddleTest;
import com.sifionsolution.codex.riddle.test.analysis.AnalysisWrapper;
import com.sifionsolution.codex.riddle.test.analysis.UserFeedbackWrapper;

@RequestScoped
public class AnalysisWrapperBuilder {

	@Inject
	private TimeChartBuilder timeChartBuilder;

	@Inject
	private OverallChartBuilder overallChartBuilder;

	@Inject
	private GuessesChartBuilder guessesChartBuilder;

	@Inject
	private AnswerAnalysisBuilder answerBuilder;

	public AnalysisWrapper build(List<RiddleTest> tests) {
		List<UserFeedbackWrapper> feedbacks = new ArrayList<UserFeedbackWrapper>();

		Integer total = tests.size();
		Integer solved = 0;
		Integer gaveups = 0;

		timeChartBuilder.withTotal(total);
		guessesChartBuilder.withTotal(total);

		for (RiddleTest test : tests) {
			timeChartBuilder.compute(test);
			guessesChartBuilder.compute(test);
			answerBuilder.compute(test);

			if (test.getComment() != null) {
				feedbacks.add(new UserFeedbackWrapper(test.getUsername(), test.getComment()));
			}

			if (test.getSolved() == true)
				solved++;
			else
				gaveups++;
		}

		// Creating charts
		ChartWrapper overall = overallChartBuilder.numberOfTests(total).withFeedbacks(feedbacks.size())
				.wasSolved(solved).wasGivinUp(gaveups).build();

		ChartWrapper time = timeChartBuilder.build();

		ChartWrapper guesses = guessesChartBuilder.build();

		List<AnswerAnalysisWrapper> answers = answerBuilder.build();

		return new AnalysisWrapper(overall, time, guesses, feedbacks, answers);
	}

}
