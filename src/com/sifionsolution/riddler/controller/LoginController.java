package com.sifionsolution.riddler.controller;

import javax.inject.Inject;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;

import com.sifionsolution.riddler.model.dto.SignInUser;

@Controller
public class LoginController {

	@Inject
	private Subject currentUser;

	@Get("/entrar")
	public void index() {
	}

	@Post("/login")
	public void login(SignInUser user) {
		try {
			currentUser.login(new UsernamePasswordToken(user.getUsername(), user.getPassword(), user.getRemember()));
		} catch (UnknownAccountException e) {
		} catch (IncorrectCredentialsException e) {
		} catch (LockedAccountException e) {
		} catch (ExcessiveAttemptsException e) {
		} catch (AuthenticationException e) {
		}
	}

	@Get("/logout")
	public void logout() {
		currentUser.logout();
	}
}
