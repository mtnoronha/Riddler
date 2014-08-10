package com.sifionsolution.codex.security.redirector;

import java.util.List;

import br.com.caelum.vraptor.Result;

import com.sifionsolution.codex.enums.Role;

public abstract class Redirector {
	protected Result result;
	private final List<Role> intercepts;

	protected Redirector next;

	public Redirector(Result result, List<Role> intercepts) {
		this.result = result;
		this.intercepts = intercepts;
	}

	public void setNext(Redirector redirector) {
		next = redirector;
	}

	public void intercept(List<Role> userRoles) {
		boolean contains = false;

		for (Role methodRole : userRoles) {
			if (intercepts.contains(methodRole)) {
				contains = true;
				break;
			}
		}

		if (!contains) {
			redirect();
		}

		if (contains && next != null) {
			next.intercept(userRoles);
		}
	}

	protected abstract void redirect();

}
