package com.sifionsolution.codex.controller;

import static com.sifionsolution.codex.enums.Role.LOGGED_IN;

import java.util.ResourceBundle;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;

import com.sifionsolution.codex.model.RiddleTest;
import com.sifionsolution.codex.model.wrapper.RiddleWrapper;
import com.sifionsolution.codex.riddle.test.RiddleTestControl;
import com.sifionsolution.codex.security.AllowTo;

@Controller
@AllowTo(LOGGED_IN)
public class RiddleTestController {

	@Inject
	private Result result;

	@Inject
	private RiddleTestControl control;

	@Inject
	private ResourceBundle bundle;

	@Get("/test")
	public void index() {
		RiddleTest actual = control.getCurrent();

		if (actual == null) {

			// TODO extract this bundle setting to elsewhere
			I18nMessage msg = new I18nMessage("", "riddle.no.riddles.available");
			msg.setBundle(bundle);

			result.include("msg", msg);
		} else {
			result.include("riddle", new RiddleWrapper(actual.getRiddle()));
		}

	}

	@Post("/test/answer")
	public void answer(String answer) {
		control.answer(answer);

		if (control.isSolved()) {
			result.redirectTo(RiddleTestController.class).survey(control.getCurrent());
		} else {
			result.include("clue", control.getClue());

			result.redirectTo(RiddleTestController.class).index();
		}
	}

	@Post("/test/giveup")
	public void giveup() {
		control.giveup();
		result.redirectTo(RiddleTestController.class).survey(control.getCurrent());
	}

	@Get("/test/correct")
	public void survey(RiddleTest test) {
		if (test != null) {
			result.include("test", test.getId());
		} else {
			result.redirectTo(RiddleTestController.class).index();
		}
	}

	@Post("/test/finish")
	public void finish(RiddleTest test, String comment) {
		control.comment(test, comment);

		result.redirectTo(RiddleTestController.class).index();
	}
}
