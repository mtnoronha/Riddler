package com.sifionsolution.codex.analysis;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import com.sifionsolution.codex.analysis.wrapper.AnswerAnalysisWrapper;
import com.sifionsolution.codex.analysis.wrapper.AnswerAnalysisWrapper.Background;
import com.sifionsolution.codex.model.RiddleTest;
import com.sifionsolution.codex.model.RiddleTestAnswer;

@RequestScoped
public class AnswerAnalysisBuilder {

	private List<AnswerAnalysisWrapper> answers;

	@PostConstruct
	public void init() {
		answers = new ArrayList<AnswerAnalysisWrapper>();
	}

	public void compute(RiddleTest test) {

		for (RiddleTestAnswer answer : test.getAnswers()) {
			AnswerAnalysisWrapper wrapper = getWrapperFor(answer);
			wrapper.increaseGuesses();
		}

	}

	public List<AnswerAnalysisWrapper> build() {
		Collections.sort(answers, new Comparator<AnswerAnalysisWrapper>() {

			@Override
			public int compare(AnswerAnalysisWrapper o1, AnswerAnalysisWrapper o2) {
				return o1.getTimesGuessed().compareTo(o2.getTimesGuessed());
			}
		});

		return unmodifiableList(answers);
	}

	private AnswerAnalysisWrapper getWrapperFor(RiddleTestAnswer answer) {
		String text = String.valueOf(answer.getAnswer()).toLowerCase();

		for (AnswerAnalysisWrapper wrapper : answers) {
			if (wrapper.getAnswer().equalsIgnoreCase(text)) {
				return wrapper;
			}
		}

		Background background = getBackgroundFor(answer);
		AnswerAnalysisWrapper newWrapper = new AnswerAnalysisWrapper(text, 0, background);
		answers.add(newWrapper);

		return newWrapper;
	}

	private Background getBackgroundFor(RiddleTestAnswer answer) {
		if (answer.isCorrectAnswer())
			return Background.ANSWER;

		if (answer.isClueUnlocker()) {
			return Background.CLUE;
		}

		return Background.OTHER;
	}

}
