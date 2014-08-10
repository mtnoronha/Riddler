package com.sifionsolution.codex.model.dto;

import javax.validation.constraints.NotNull;

public class SaveableClue {

	private final Long id;

	@NotNull(message = "empty.answer")
	private final String answer;

	@NotNull(message = "empty.clue")
	private final String clue;

	public SaveableClue(Long id, String answer, String clue) {
		this.id = id;
		this.answer = answer;
		this.clue = clue;
	}

	public final Long getId() {
		return id;
	}

	public final String getAnswer() {
		return answer;
	}

	public final String getClue() {
		return clue;
	}

}
