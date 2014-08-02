package com.sifionsolution.riddler.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_riddle")
public class Riddle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false)
	private String answer;

	@Column(nullable = false)
	private Integer reward;

	@Column(nullable = false)
	private Integer level;

	@OneToMany(mappedBy = "riddle")
	private List<Clue> clues;

	public Riddle() {
	}

	public Riddle(Long id, String description, String answer, Integer reward, Integer level, List<Clue> clues) {
		this.id = id;
		this.description = description;
		this.answer = answer;
		this.reward = reward;
		this.level = level;
		this.clues = clues;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getAnswer() {
		return answer;
	}

	public Integer getReward() {
		return reward;
	}

	public Integer getLevel() {
		return level;
	}

	public List<Clue> getClues() {
		return clues;
	}

}