package com.sifionsolution.riddler.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.validator.I18nMessage;

import com.sifionsolution.riddler.model.dto.SignInUser;

@RequestScoped
public class Authenticator {

	@Inject
	private Subject currentUser;

	public I18nMessage authenticate(SignInUser user) {
		try {
			currentUser.login(new UsernamePasswordToken(user.getUsername(), user.getPassword(), false));
		} catch (Exception e) {
			return new I18nMessage("", "login.unsuccessful");
		}

		return null;

	}

	public void logoff() {
		currentUser.logout();
	}

}
