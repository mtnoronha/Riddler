package com.sifionsolution.riddler.security.redirector.implementations;

import static com.sifionsolution.riddler.enums.Role.LOGGED_OFF;

import java.util.Arrays;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.Result;

import com.sifionsolution.riddler.controller.RootController;
import com.sifionsolution.riddler.security.redirector.Redirector;

@RequestScoped
public class RootRedirector extends Redirector {

	public RootRedirector(Result result) {
		super(result, Arrays.asList(LOGGED_OFF));
	}

	@Override
	protected void redirect() {
		result.redirectTo(RootController.class).index();
	}

}
