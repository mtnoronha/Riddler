package com.sifionsolution.codex.riddle.test.analysis;

public class UserFeedbackWrapper {

	private String user;
	private String feedback;

	public UserFeedbackWrapper(String user, String feedback) {
		this.user = user;
		this.feedback = feedback;
	}

	public String getUser() {
		return user;
	}

	public String getFeedback() {
		return feedback;
	}

}
