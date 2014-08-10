package com.sifionsolution.codex.security.redirector.implementations;

import static com.sifionsolution.codex.enums.Role.LOGGED_IN;

import java.util.Arrays;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.Result;

import com.sifionsolution.codex.controller.LoginController;
import com.sifionsolution.codex.security.redirector.Redirector;

@RequestScoped
public class SignInRedirector extends Redirector {

	public SignInRedirector(Result result) {
		super(result, Arrays.asList(LOGGED_IN));
	}

	@Override
	protected void redirect() {
		result.redirectTo(LoginController.class).index();
	}

}
