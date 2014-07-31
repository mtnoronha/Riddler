package com.sifionsolution.riddler.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.annotation.Secured;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.sifionsolution.riddler.model.dto.SignInUser;
import com.sifionsolution.riddler.security.Authenticator;

@Controller
@Secured
public class LoginController {

	@Inject
	private Result result;

	@Inject
	private Validator validator;

	@Inject
	private Authenticator auth;

	@RequiresGuest
	@Get("/entrar")
	public void index() {
	}

	@RequiresGuest
	@Post("/login")
	public void login(@NotNull @Valid SignInUser user) {
		validator.onErrorRedirectTo(LoginController.class).index();

		I18nMessage loginError = auth.authenticate(user);

		if (loginError != null)
			validator.add(loginError);

		result.redirectTo(RootController.class).index();
	}

	@RequiresAuthentication
	@Get("/logout")
	public void logout() {
		auth.logoff();
	}
}
