package com.sifionsolution.riddler.security.redirector;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.Result;

import com.sifionsolution.riddler.security.redirector.implementations.AdminRedirector;
import com.sifionsolution.riddler.security.redirector.implementations.ModeratorRedirector;
import com.sifionsolution.riddler.security.redirector.implementations.RootRedirector;
import com.sifionsolution.riddler.security.redirector.implementations.SignInRedirector;

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
