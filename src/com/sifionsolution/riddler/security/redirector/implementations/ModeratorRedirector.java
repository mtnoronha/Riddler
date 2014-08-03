package com.sifionsolution.riddler.security.redirector.implementations;

import static com.sifionsolution.riddler.enums.Role.MODERATOR;

import java.util.Arrays;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.Result;

import com.sifionsolution.riddler.controller.RootController;
import com.sifionsolution.riddler.security.redirector.Redirector;

@RequestScoped
public class ModeratorRedirector extends Redirector {

	public ModeratorRedirector(Result result) {
		super(result, Arrays.asList(MODERATOR));
	}

	@Override
	protected void redirect() {
		result.redirectTo(RootController.class).index();
	}

}
