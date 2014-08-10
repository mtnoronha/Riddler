package com.sifionsolution.codex.model.wrapper;

import com.sifionsolution.codex.model.Riddle;

public class RiddleWrapper {

	private final String description;

	public RiddleWrapper(Riddle riddle) {
		description = riddle.getDescription();
	}

	public final String getDescription() {
		return description;
	}

}
