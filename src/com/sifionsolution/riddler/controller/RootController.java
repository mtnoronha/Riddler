package com.sifionsolution.riddler.controller;

import static com.sifionsolution.riddler.enums.Role.LOGGED_IN;
import static com.sifionsolution.riddler.enums.Role.LOGGED_OFF;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

import com.sifionsolution.riddler.security.AllowTo;

@Controller
@AllowTo({ LOGGED_IN, LOGGED_OFF })
public class RootController {

	@Path("/")
	public void index() {
	}

}
