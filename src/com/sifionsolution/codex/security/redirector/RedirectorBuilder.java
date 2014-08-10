package com.sifionsolution.codex.security.redirector;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.Result;

import com.sifionsolution.codex.security.redirector.implementations.AdminRedirector;
import com.sifionsolution.codex.security.redirector.implementations.ModeratorRedirector;
import com.sifionsolution.codex.security.redirector.implementations.RootRedirector;
import com.sifionsolution.codex.security.redirector.implementations.SignInRedirector;

@RequestScoped
public class RedirectorBuilder {

	public Redirector build(Result result) {
		Redirector signIn = new SignInRedirector(result);
		Redirector root = new RootRedirector(result);
		Redirector moderator = new ModeratorRedirector(result);
		Redirector admin = new AdminRedirector(result);

		signIn.setNext(root);
		root.setNext(moderator);
		moderator.setNext(admin);

		return signIn;
	}
}
