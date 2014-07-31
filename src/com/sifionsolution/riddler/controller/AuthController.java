package com.sifionsolution.riddler.controller;

import javax.inject.Inject;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.AuthorizationRestrictionListener;

@Controller
public class AuthController implements AuthorizationRestrictionListener {

	@Inject
	private Result result;

	@Inject
	private Subject currentUser;

	@Override
	public void onAuthorizationRestriction(AuthorizationException e) {
		result.include("error", e.toString());

		if (currentUser.isAuthenticated())
			result.redirectTo(RootController.class).index();
		else
			result.redirectTo(LoginController.class).index();

	}

}
