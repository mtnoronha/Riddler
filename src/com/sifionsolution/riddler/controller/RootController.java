package com.sifionsolution.riddler.controller;

import javax.inject.Inject;

import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class RootController {

	@Inject
	private Subject currentUser;

	@Path("/")
	public void index() {
	}

}
