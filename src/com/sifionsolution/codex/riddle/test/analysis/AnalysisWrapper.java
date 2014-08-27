package com.sifionsolution.codex.riddle.test.analysis;

import java.util.List;

import com.sifionsolution.codex.analysis.wrapper.AnswerAnalysisWrapper;
import com.sifionsolution.codex.google.charts.ChartWrapper;

public class AnalysisWrapper {

	private ChartWrapper overall;
	private ChartWrapper time;
	private ChartWrapper guesses;
	private List<UserFeedbackWrapper> feedbacks;
	private List<AnswerAnalysisWrapper> answers;

	public AnalysisWrapper(ChartWrapper overall, ChartWrapper time, ChartWrapper guesses,
			List<UserFeedbackWrapper> feedbacks, List<AnswerAnalysisWrapper> answers) {
		this.overall = overall;
		this.time = time;
		this.guesses = guesses;
		this.feedbacks = feedbacks;
		this.answers = answers;
	}

	public ChartWrapper getOverall() {
		return overall;
	}

	public ChartWrapper getTime() {
		return time;
	}

	public ChartWrapper getGuesses() {
		return guesses;
	}

	public List<UserFeedbackWrapper> getFeedbacks() {
		return feedbacks;
	}

	public List<AnswerAnalysisWrapper> getAnswers() {
		return answers;
	}

}
