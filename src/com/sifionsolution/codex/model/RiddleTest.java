package com.sifionsolution.codex.model;

import static org.joda.time.DateTime.now;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "tb_riddle_test")
public class RiddleTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_riddle")
	private Riddle riddle;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	private DateTime start;

	private DateTime end;

	@Column(columnDefinition = "TEXT")
	private String comment;

	@Column(columnDefinition = "TINYINT(1)")
	private Boolean solved;

	@OneToMany(mappedBy = "riddleTest")
	private List<RiddleTestAnswer> answers;

	public RiddleTest() {
	}

	public RiddleTest(Long id, DateTime start, DateTime end, String comment, Boolean solved, Riddle riddle, User user,
			List<RiddleTestAnswer> answers) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.comment = comment;
		this.solved = solved;
		this.riddle = riddle;
		this.user = user;
		this.answers = answers;
	}

	public boolean checkAnswer(String answer) {
		return riddle.check(answer);
	}

	public String findClue(String answer) {
		return riddle.findClue(answer);
	}

	public void riddleSolved() {
		solved = true;
		end = now();
	}

	public void giveUp() {
		solved = false;
		end = now();
	}

	public Long getId() {
		return id;
	}

	public DateTime getStart() {
		return start;
	}

	public DateTime getEnd() {
		return end;
	}

	public String getComment() {
		return comment;
	}

	public Boolean getSolved() {
		return solved;
	}

	public Riddle getRiddle() {
		return riddle;
	}

	public User getUser() {
		return user;
	}

	public Integer numberOfAnswers() {
		return answers.size();
	}

	public List<RiddleTestAnswer> getAnswers() {
		return answers;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return user.getUsername();
	}

}