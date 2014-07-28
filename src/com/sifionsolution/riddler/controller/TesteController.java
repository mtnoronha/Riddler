package com.sifionsolution.riddler.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

import com.sifionsolution.riddler.model.Teste;
import com.sifionsolution.riddler.model.dao.TesteDAO;

@Controller
public class TesteController {

	@Inject
	private TesteDAO dao;

	@Inject
	private Result result;

	@Path("/teste")
	public void index() {
	}

	@Post("/teste/save")
	public void save(Teste obj) {
		dao.save(obj);
		result.include("msg", "OKKKKK !!");
		result.redirectTo(this).index();
	}
}
