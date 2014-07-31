package com.sifionsolution.riddler.model;

import static javax.persistence.EnumType.STRING;

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

import com.sifionsolution.riddler.enums.Role;

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Long id;

	private final String name;

	private final String username;

	private final String email;

	private final String password;

	@ElementCollection(targetClass = Role.class)
	@CollectionTable(name = "tb_role", joinColumns = @JoinColumn(name = "id_user"))
	@Column(name = "role")
	@Enumerated(STRING)
	private final List<Role> roles;

	public User(Long id, String name, String username, String email, String password, List<Role> roles) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
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