package com.sifionsolution.codex.security.redirector.implementations;

import static com.sifionsolution.codex.enums.Role.MODERATOR;

import java.util.Arrays;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.Result;

import com.sifionsolution.codex.controller.RootController;
import com.sifionsolution.codex.security.redirector.Redirector;

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
