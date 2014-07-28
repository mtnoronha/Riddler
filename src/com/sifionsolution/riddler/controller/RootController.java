package com.sifionsolution.riddler.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class RootController {

	@Get("/")
	public void index() {
	}
}
