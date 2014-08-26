package com.sifionsolution.codex.riddle.test.analysis;

import com.sifionsolution.codex.google.charts.ChartWrapper;

public class AnalysisWrapper {

	private ChartWrapper overall;
	private ChartWrapper time;
	private ChartWrapper guesses;

	public AnalysisWrapper(ChartWrapper overall, ChartWrapper time, ChartWrapper guesses) {
		this.overall = overall;
		this.time = time;
		this.guesses = guesses;
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

}
