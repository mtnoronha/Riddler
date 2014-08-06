package com.sifionsolution.riddler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "tb_riddle_test_answer")
public class RiddleTestAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_riddle_test")
	private RiddleTest riddleTest;

	private String answer;

	private DateTime time;

	public RiddleTestAnswer() {
	}

	public RiddleTestAnswer(Long id, RiddleTest riddleTest, String answer, DateTime time) {
		this.id = id;
		this.riddleTest = riddleTest;
		this.answer = answer;
		this.time = time;
	}

	public boolean isCorrectAnswer() {
		return riddleTest.checkAnswer(answer);
	}

	public String findClue() {
		return riddleTest.findClue(answer);
	}

	public final Long getId() {
		return id;
	}

	public final RiddleTest getRiddleTest() {
		return riddleTest;
	}

	public final String getAnswer() {
		return answer;
	}

	public final DateTime getTime() {
		return time;
	}

}