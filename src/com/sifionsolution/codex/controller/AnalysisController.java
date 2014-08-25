package com.sifionsolution.codex.controller;

import static com.sifionsolution.codex.enums.Role.ADMIN;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

import com.sifionsolution.codex.security.AllowTo;

@Controller
@AllowTo(ADMIN)
public class AnalysisController {

	@Inject
	private Result result;

	@Get("/analysis")
	public void index() {
	}

}
