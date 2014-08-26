package com.sifionsolution.codex.riddle.test.analysis;

import java.util.List;

import com.sifionsolution.codex.google.charts.ChartWrapper;

public class AnalysisWrapper {

	private ChartWrapper overall;
	private ChartWrapper time;
	private ChartWrapper guesses;
	private List<UserFeedbackWrapper> feedbacks;

	public AnalysisWrapper(ChartWrapper overall, ChartWrapper time, ChartWrapper guesses,
			List<UserFeedbackWrapper> feedbacks) {
		this.overall = overall;
		this.time = time;
		this.guesses = guesses;
		this.feedbacks = feedbacks;
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

}
