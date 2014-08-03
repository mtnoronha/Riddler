package com.sifionsolution.riddler.controller;

import static com.sifionsolution.riddler.enums.Role.ADMIN;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

import com.sifionsolution.riddler.security.AllowTo;

@Controller
@AllowTo(ADMIN)
public class AdminController {

	@Get("/admin")
	public void index() {
	}
}
