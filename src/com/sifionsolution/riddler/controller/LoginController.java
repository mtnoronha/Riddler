package com.sifionsolution.riddler.controller;

import javax.inject.Inject;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.annotation.Secured;

import com.sifionsolution.riddler.model.dto.SignInUser;

@Controller
@Secured
public class LoginController {

	@Inject
	private Subject currentUser;

	@Inject
	private Result result;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequiresGuest
	@Get("/entrar")
	public void index() {
	}

	@RequiresGuest
	@Post("/login")
	public void login(SignInUser user) {
		try {
			currentUser.login(new UsernamePasswordToken(user.getUsername(), user.getPassword(), false));
			result.redirectTo(RootController.class).index();
		} catch (Exception e) {
			logger.error("Login attempt unsuccessful", e);
			result.redirectTo(this).index();
		}
	}

	@RequiresAuthentication
	@Get("/logout")
	public void logout() {
		currentUser.logout();
	}
}
