package com.sifionsolution.riddler.security;

import static com.sifionsolution.commons.util.ContentVerifyer.isEmpty;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.sifionsolution.riddler.enums.Role;

@RequestScoped
public class AccessService {

	@Inject
	private UserWeb user;

	public boolean canAccess(List<Annotation> annotations) {
		if (isEmpty(annotations))
			return true;

		for (Annotation annotation : annotations)
			if (annotation instanceof AllowTo)
				return this.containsAnyFeature(annotation);

		return true;
	}

	protected boolean containsAnyFeature(Annotation annotation) {
		AllowTo allowTo = (AllowTo) annotation;
		return user.containsAny(Arrays.asList(allowTo.value()));
	}

	public List<Role> getUserFeatures() {
		return user.getUserRoles();
	}
}
