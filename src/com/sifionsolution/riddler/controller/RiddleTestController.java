package com.sifionsolution.riddler.controller;

import static com.sifionsolution.riddler.enums.Role.LOGGED_IN;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

import com.sifionsolution.riddler.model.dao.RiddleTestDAO;
import com.sifionsolution.riddler.model.dto.SaveableRiddleTest;
import com.sifionsolution.riddler.security.AllowTo;

@Controller
@AllowTo(LOGGED_IN)
public class RiddleTestController {

	@Inject
	private RiddleTestDAO dao;

	@Inject
	private Result result;

	@Get("/teste")
	public void index() {
		// TODO include actual RiddleTest (unfinished) or NEXT RiddleTest
		// If none exists, include a msg.

		// Should use a RiddleWrapper.
	}

	@Post("/teste/responder")
	public void answer(String answer) {
		// TODO save the answer on current Riddle Test
	}

	@Post("/teste/finalizar")
	public void finish(SaveableRiddleTest test) {

	}
}
