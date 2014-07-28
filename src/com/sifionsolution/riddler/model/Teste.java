package com.sifionsolution.riddler.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teste")
public class Teste {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String test;

	public Teste() {
	}

	public Teste(Long id, String test) {
		this.id = id;
		this.test = test;
	}

	public Long getId() {
		return id;
	}

	public String getTest() {
		return test;
	}

}
