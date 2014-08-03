package com.sifionsolution.riddler.controller;

import static com.sifionsolution.riddler.enums.Role.LOGGED_IN;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

import com.sifionsolution.riddler.security.AllowTo;

@Controller
@AllowTo(LOGGED_IN)
public class ProfileController {

	@Get("/perfil")
	public void index() {
	}

}
