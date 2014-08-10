package com.sifionsolution.codex.model;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.sifionsolution.codex.enums.Role;
import com.sifionsolution.codex.model.dto.SignUpUser;

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String username;

	private String email;

	private String password;

	@ElementCollection(targetClass = Role.class, fetch = LAZY)
	@CollectionTable(name = "tb_role", joinColumns = @JoinColumn(name = "id_user"))
	@Column(name = "role")
	@Enumerated(STRING)
	private List<Role> roles;

	public User() {
	}

	public User(Long id, String name, String username, String email, String password, List<Role> roles) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public void load(SignUpUser dto, String encrypted) {
		name = dto.getName();
		username = dto.getUsername();
		email = dto.getEmail();
		password = encrypted;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Role> getRoles() {
		return roles;
	}

}