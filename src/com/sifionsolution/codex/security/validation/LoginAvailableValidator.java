package com.sifionsolution.codex.security.validation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sifionsolution.codex.model.dao.UserDAO;
import com.sifionsolution.codex.model.dto.SignUpUser;

public class LoginAvailableValidator implements ConstraintValidator<LoginAvailable, SignUpUser> {

	@Inject
	private UserDAO userDao;

	@Override
	public boolean isValid(SignUpUser user, ConstraintValidatorContext context) {
		return !userDao.containsUserWith(user.getUsername(), user.getEmail());
	}

	@Override
	public void initialize(LoginAvailable la) {
	}
}