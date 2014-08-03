package com.sifionsolution.riddler.controller;

import static com.sifionsolution.riddler.enums.Role.LOGGED_OFF;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.sifionsolution.riddler.model.dao.UserDAO;
import com.sifionsolution.riddler.model.dto.SignUpUser;
import com.sifionsolution.riddler.security.AllowTo;

@Controller
@AllowTo(LOGGED_OFF)
public class RegisterController {

	@Inject
	private Result result;

	@Inject
	private Validator validator;

	@Inject
	private UserDAO dao;

	@Get("/registro")
	public void index() {
	}

	@Post("/registrar")
	public void register(@NotNull @Valid SignUpUser user) {
		validator.onErrorRedirectTo(RegisterController.class).index();

		dao.register(user);

		result.redirectTo(RootController.class).index();
	}

}
