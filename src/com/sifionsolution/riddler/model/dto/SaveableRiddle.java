package com.sifionsolution.riddler.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveableRiddle {

	private Long id;

	@NotNull(message = "empty.description")
	private String description;

	@NotNull(message = "empty.answer")
	private String answer;

	@NotNull(message = "empty.reward")
	@Size(min = 1, message = "invalid.reward")
	private Integer reward;

	@NotNull(message = "empty.level")
	@Size(min = 0, message = "invalid.level")
	private Integer level;

	public SaveableRiddle(Long id, String description, String answer, Integer reward, Integer level) {
		this.id = id;
		this.description = description;
		this.answer = answer;
		this.reward = reward;
		this.level = level;
	}

	public final Long getId() {
		return id;
	}

	public final String getDescription() {
		return description;
	}

	public final String getAnswer() {
		return answer;
	}

	public final Integer getReward() {
		return reward;
	}

	public final Integer getLevel() {
		return level;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final void setAnswer(String answer) {
		this.answer = answer;
	}

	public final void setReward(Integer reward) {
		this.reward = reward;
	}

	public final void setLevel(Integer level) {
		this.level = level;
	}

}
