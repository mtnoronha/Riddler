package com.sifionsolution.riddler.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_riddle_test")
public class RiddleTestAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_riddle_test_answer")
	private RiddleTest riddleTest;

	private String answer;

	private LocalDateTime time;

	public RiddleTestAnswer() {
	}

	public RiddleTestAnswer(Long id, RiddleTest riddleTest, String answer, LocalDateTime time) {
		this.id = id;
		this.riddleTest = riddleTest;
		this.answer = answer;
		this.time = time;
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

	public final LocalDateTime getTime() {
		return time;
	}
}