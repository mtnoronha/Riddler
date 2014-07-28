package com.sifionsolution.riddler.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class RootController {

	@Path("/")
	public void index() {
	}

	@Path("/teste")
	public void test() {
	}
}
