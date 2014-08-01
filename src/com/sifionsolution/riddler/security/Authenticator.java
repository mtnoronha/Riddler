package com.sifionsolution.riddler.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.validator.I18nMessage;

import com.sifionsolution.riddler.model.dto.SignInUser;

@RequestScoped
public class Authenticator {

	@Inject
	private Subject currentUser;

	private static final Logger logger = LoggerFactory.getLogger(Authenticator.class);

	public I18nMessage authenticate(SignInUser user) {
		try {
			currentUser.login(new UsernamePasswordToken(user.getUsername(), user.getPassword(), false));
		} catch (Exception e) {
			logger.debug("Log in error", e);
			return new I18nMessage("", "login.unsuccessful");
		}

		return null;

	}

	public void logoff() {
		currentUser.logout();
	}

}
