package com.sifionsolution.riddler.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.validator.I18nMessage;

import com.sifionsolution.riddler.model.User;
import com.sifionsolution.riddler.model.dao.UserDAO;
import com.sifionsolution.riddler.model.dto.SignInUser;

@RequestScoped
public class Authenticator {

	@Inject
	private UserWeb userWeb;

	@Inject
	private UserDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(Authenticator.class);

	public I18nMessage authenticate(SignInUser user) {
		try {
			User entity = dao.login(user);
			userWeb.signIn(entity);
		} catch (Exception e) {
			logger.debug("Log in error", e);
			return new I18nMessage("", "login.unsuccessful");
		}

		return null;

	}

	public void logoff() {
		userWeb.signOut();
	}

}
