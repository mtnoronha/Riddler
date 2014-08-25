package com.sifionsolution.codex.model.wrapper.builder;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.sifionsolution.codex.model.User;
import com.sifionsolution.codex.model.wrapper.UserWrapper;

@RequestScoped
public class UserWrapperBuilder {

	public List<UserWrapper> build(List<User> rawList) {
		List<UserWrapper> list = new ArrayList<UserWrapper>();

		for (User user : rawList) {
			list.add(new UserWrapper(user));
		}

		return list;
	}
}
