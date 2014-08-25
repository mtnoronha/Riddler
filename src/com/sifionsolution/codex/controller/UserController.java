package com.sifionsolution.codex.controller;

import static com.sifionsolution.codex.enums.Role.ADMIN;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

import com.sifionsolution.codex.model.dao.UserDAO;
import com.sifionsolution.codex.model.wrapper.builder.UserWrapperBuilder;
import com.sifionsolution.codex.security.AllowTo;

@Controller
@AllowTo(ADMIN)
public class UserController {

	@Inject
	private UserDAO dao;

	@Inject
	private Result result;

	@Inject
	private UserWrapperBuilder builder;

	@Get("/users")
	public void list() {
		result.include("users", builder.build(dao.listAll()));
	}
}
