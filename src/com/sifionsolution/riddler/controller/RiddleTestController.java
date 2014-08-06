package com.sifionsolution.riddler.controller;

import static com.sifionsolution.riddler.enums.Role.LOGGED_IN;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;

import com.sifionsolution.riddler.model.RiddleTest;
import com.sifionsolution.riddler.model.wrapper.RiddleWrapper;
import com.sifionsolution.riddler.riddle.test.RiddleTestControl;
import com.sifionsolution.riddler.security.AllowTo;

@Controller
@AllowTo(LOGGED_IN)
public class RiddleTestController {

	@Inject
	private Result result;

	@Inject
	private RiddleTestControl control;

	@Get("/teste")
	public void index() {
		RiddleTest actual = control.getCurrent();

		if (actual == null) {
			result.include("msg", new I18nMessage("", "riddles.no.riddles.available"));
		} else {
			result.include("riddle", new RiddleWrapper(actual.getRiddle()));
		}

	}

	@Post("/teste/responder")
	public void answer(String answer) {
		control.answer(answer);

		if (control.isSolved()) {
			result.redirectTo(RiddleTestController.class).survey(control.getCurrent());
		} else {
			result.include("clue", control.getClue());

			result.redirectTo(RiddleTestController.class).index();
		}
	}

	@Get("/teste/acertou")
	public void survey(RiddleTest test) {
		result.include("test", test.getId());
	}

	// FIXME not working properly
	@Post("/teste/finalizar")
	public void finish(RiddleTest test, String comment, boolean quit) {
		control.comment(test, comment);

		if (quit) {
			result.redirectTo(RootController.class).index();
		} else {
			result.redirectTo(RiddleTestController.class).index();
		}
	}
}
