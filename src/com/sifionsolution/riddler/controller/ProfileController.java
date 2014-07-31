package com.sifionsolution.riddler.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.security.annotation.Secured;

@Secured
@Controller
public class ProfileController {

	@Get("/perfil")
	@RequiresAuthentication
	public void index() {
	}

}
