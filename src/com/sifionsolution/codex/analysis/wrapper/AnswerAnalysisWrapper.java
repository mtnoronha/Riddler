package com.sifionsolution.codex.analysis.wrapper;

public class AnswerAnalysisWrapper {

	private String answer;
	private Integer timesGuessed;
	private String background;

	public AnswerAnalysisWrapper(String answer, Integer timesGuessed, Background background) {
		this.answer = answer;
		this.timesGuessed = timesGuessed;
		this.background = background.getBackground();
	}

	public String getAnswer() {
		return answer;
	}

	public Integer getTimesGuessed() {
		return timesGuessed;
	}

	public String getBackground() {
		return background;
	}

	public void increaseGuesses() {
		timesGuessed++;
	}

	public enum Background {
		CLUE("bg-info"), ANSWER("bg-success"), OTHER("bg-warning");

		private String background;

		private Background(String background) {
			this.background = background;
		}

		public String getBackground() {
			return background;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.toLowerCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerAnalysisWrapper other = (AnswerAnalysisWrapper) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equalsIgnoreCase(other.answer))
			return false;
		return true;
	}

}
