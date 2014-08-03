package com.sifionsolution.riddler.controller;

import static com.sifionsolution.riddler.enums.Role.LOGGED_IN;
import static com.sifionsolution.riddler.enums.Role.LOGGED_OFF;

import javax.inject.Inject;

import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

import com.sifionsolution.riddler.security.AllowTo;

@Controller
@AllowTo({ LOGGED_IN, LOGGED_OFF })
public class RootController {

	@Inject
	private Subject currentUser;

	@Path("/")
	public void index() {
	}

}
