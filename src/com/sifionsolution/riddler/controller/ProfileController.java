package com.sifionsolution.riddler.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.security.annotation.Secured;

@Secured
@RequiresAuthentication
@Controller
public class ProfileController {

	@Get("/perfil")
	public void index() {
	}

}
