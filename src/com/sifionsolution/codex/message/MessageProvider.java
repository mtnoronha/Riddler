package com.sifionsolution.codex.message;

import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;

@RequestScoped
public class MessageProvider {

	@Inject
	private ResourceBundle bundle;

	// FIXME shouldnot be here
	private String[] wrongAnswerKeys = { "riddle.wrong.answer1", "riddle.wrong.answer2", "riddle.wrong.answer3",
			"riddle.wrong.answer4", "riddle.wrong.answer5", "riddle.wrong.answer6", "riddle.wrong.answer7",
			"riddle.wrong.answer8", "riddle.wrong.answer9", "riddle.wrong.answer10", "riddle.wrong.answer11",
			"riddle.wrong.answer12", "riddle.wrong.answer13", "riddle.wrong.answer14", "riddle.wrong.answer15",
			"riddle.wrong.answer16", "riddle.wrong.answer17", "riddle.wrong.answer18", "riddle.wrong.answer19",
			"riddle.wrong.answer20" };

	public I18nMessage getMessage(String key) {
		I18nMessage msg = new I18nMessage("", key);
		msg.setBundle(bundle);

		return msg;
	}

	// FIXME this should not be here
	public I18nMessage randomWrongAnswerMessage() {
		String key = wrongAnswerKeys[(int) (Math.random() * wrongAnswerKeys.length)];
		return getMessage(key);
	}
}
