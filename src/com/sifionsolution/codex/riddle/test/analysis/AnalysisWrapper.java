package com.sifionsolution.codex.riddle.test.analysis;

import com.sifionsolution.codex.google.charts.ChartWrapper;

public class AnalysisWrapper {

	private ChartWrapper overall;
	private ChartWrapper time;

	public AnalysisWrapper(ChartWrapper overall, ChartWrapper time) {
		this.overall = overall;
		this.time = time;
	}

	public ChartWrapper getOverall() {
		return overall;
	}

	public ChartWrapper getTime() {
		return time;
	}

}
