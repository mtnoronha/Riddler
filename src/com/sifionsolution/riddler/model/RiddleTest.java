package com.sifionsolution.riddler.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	private LocalDateTime start;

	private LocalDateTime end;

	@Column(columnDefinition = "TEXT")
	private String comment;

	@Column(columnDefinition = "TINYINT(1)")
	private Boolean solved;

	public RiddleTest() {
	}

	public RiddleTest(Long id, LocalDateTime start, LocalDateTime end, String comment, Boolean solved, Riddle riddle,
			User user) {
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

	public final LocalDateTime getStart() {
		return start;
	}

	public final LocalDateTime getEnd() {
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