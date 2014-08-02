package com.sifionsolution.riddler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sifionsolution.riddler.model.dto.SaveableClue;

@Entity
@Table(name = "tb_clue")
public class Clue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String answer;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String clue;

	@ManyToOne
	@JoinColumn(name = "id_riddle", nullable = false)
	private Riddle riddle;

	public Clue() {
	}

	public Clue(Long id, String answer, String clue, Riddle riddle) {
		this.id = id;
		this.answer = answer;
		this.clue = clue;
		this.riddle = riddle;
	}

	public void load(SaveableClue clue, Riddle entity) {
		id = clue.getId();
		answer = clue.getAnswer();
		this.clue = clue.getClue();
		riddle = entity;
	}

	public Long getId() {
		return id;
	}

	public final String getAnswer() {
		return answer;
	}

	public String getClue() {
		return clue;
	}

	public Riddle getRiddle() {
		return riddle;
	}

}