package com.sifionsolution.riddler.controller;

import javax.inject.Inject;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.security.annotation.Secured;

import com.sifionsolution.riddler.model.dto.SignInUser;

@Controller
@Secured
public class LoginController {

	@Inject
	private Subject currentUser;

	@RequiresGuest
	@Get("/entrar")
	public void index() {
	}

	@RequiresGuest
	@Post("/login")
	public void login(SignInUser user) {
		try {
			currentUser.login(new UsernamePasswordToken(user.getUsername(), user.getPassword(), false));
		} catch (UnknownAccountException e) {
		} catch (IncorrectCredentialsException e) {
		} catch (LockedAccountException e) {
		} catch (ExcessiveAttemptsException e) {
		} catch (AuthenticationException e) {
		}
	}

	@RequiresAuthentication
	@Get("/logout")
	public void logout() {
		currentUser.logout();
	}
}
