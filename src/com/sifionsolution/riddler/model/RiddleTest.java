package com.sifionsolution.riddler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	public RiddleTest() {
	}

	public RiddleTest(Long id, DateTime start, DateTime end, String comment, Boolean solved, Riddle riddle, User user) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.comment = comment;
		this.solved = solved;
		this.riddle = riddle;
		this.user = user;
	}

	public final Long getId() {
		return id;
	}

	public final DateTime getStart() {
		return start;
	}

	public final DateTime getEnd() {
		return end;
	}

	public final String getComment() {
		return comment;
	}

	public final Boolean getSolved() {
		return solved;
	}

	public final Riddle getRiddle() {
		return riddle;
	}

	public final User getUser() {
		return user;
	}

}