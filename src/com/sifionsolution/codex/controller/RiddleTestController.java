package com.sifionsolution.codex.controller;

import static com.sifionsolution.codex.enums.Role.LOGGED_IN;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

import com.sifionsolution.codex.message.MessageProvider;
import com.sifionsolution.codex.model.RiddleTest;
import com.sifionsolution.codex.model.wrapper.RiddleWrapper;
import com.sifionsolution.codex.riddle.test.RiddleTestControl;
import com.sifionsolution.codex.security.AllowTo;
import com.sifionsolution.commons.ContentVerifyer;

@Controller
@AllowTo(LOGGED_IN)
public class RiddleTestController {

	@Inject
	private Result result;

	@Inject
	private RiddleTestControl control;

	@Inject
	private MessageProvider messageProvider;

	@Get("/test")
	public void index() {
		RiddleTest actual = control.getCurrent();

		if (actual == null) {
			result.include("msg", messageProvider.getMessage("riddle.no.riddles.available"));
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
			String clue = control.getClue();

			if (ContentVerifyer.notEmpty(clue)) {
				result.include("clue", clue);
			} else {
				result.include("wrong", messageProvider.randomWrongAnswerMessage());
			}

			result.redirectTo(RiddleTestController.class).index();
		}
	}

	@Post("/test/giveup")
	public void giveup() {
		control.giveup();
		result.redirectTo(RiddleTestController.class).survey(control.getCurrent());
	}

	@Get("/test/survey")
	public void survey(RiddleTest test) {
		if (test != null) {
			result.include("test", test.getId());
		} else {
			result.redirectTo(RiddleTestController.class).index();
		}
	}

	@Post("/test/finish")
	public void finish(RiddleTest test, String comment) {
		if (test != null)
			control.comment(test, comment);

		result.redirectTo(RiddleTestController.class).index();
	}
}
