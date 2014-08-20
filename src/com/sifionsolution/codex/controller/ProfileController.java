package com.sifionsolution.codex.controller;

import static com.sifionsolution.codex.enums.Role.LOGGED_IN;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

import com.sifionsolution.codex.security.AllowTo;

@Controller
@AllowTo(LOGGED_IN)
public class ProfileController {

	@Get("/profile")
	public void index() {
	}

}
