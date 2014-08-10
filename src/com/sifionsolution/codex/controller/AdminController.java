package com.sifionsolution.codex.controller;

import static com.sifionsolution.codex.enums.Role.ADMIN;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

import com.sifionsolution.codex.security.AllowTo;

@Controller
@AllowTo(ADMIN)
public class AdminController {

	@Get("/admin")
	public void index() {
	}
}
