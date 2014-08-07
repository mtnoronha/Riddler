package com.sifionsolution.riddler.controller;

import static com.sifionsolution.riddler.enums.Role.LOGGED_IN;
import static com.sifionsolution.riddler.enums.Role.LOGGED_OFF;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.sifionsolution.riddler.model.dto.SignInUser;
import com.sifionsolution.riddler.security.AllowTo;
import com.sifionsolution.riddler.security.Authenticator;

@Controller
public class LoginController {

	@Inject
	private Result result;

	@Inject
	private Validator validator;

	@Inject
	private Authenticator auth;

	@AllowTo(LOGGED_OFF)
	@Get("/entrar")
	public void index() {
	}

	@AllowTo(LOGGED_OFF)
	@Post("/login")
	public void login(@NotNull @Valid SignInUser user) {
		validator.onErrorRedirectTo(LoginController.class).index();

		I18nMessage loginError = auth.authenticate(user);

		if (loginError != null) {
			validator.add(loginError);
			validator.onErrorRedirectTo(LoginController.class).index();
		}

		result.redirectTo(RootController.class).index();
	}

	@AllowTo(LOGGED_IN)
	@Get("/logout")
	public void logout() {
		auth.logoff();
		result.redirectTo(RootController.class).index();
	}
}
