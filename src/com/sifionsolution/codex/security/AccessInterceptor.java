package com.sifionsolution.codex.security;

import static br.com.caelum.vraptor.view.Results.status;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

import com.sifionsolution.codex.security.redirector.RedirectorBuilder;

@Intercepts
public class AccessInterceptor {

	@Inject
	private Result result;

	@Inject
	private AccessService service;

	@Inject
	private HttpServletRequest request;

	@Inject
	private RedirectorBuilder redirectorBuilder;

	@AroundCall
	public void around(SimpleInterceptorStack stack) {
		if ("true".equals(request.getParameter("isAjax")))
			ajaxForbiddenError();
		else
			redirectorBuilder.build(result).intercept(service.getUserFeatures());

	}

	private void ajaxForbiddenError() {
		result.use(status()).forbidden("You cannot access this page.");
	}

	@Accepts
	public boolean accepts(ControllerMethod method) {
		return !service.canAccess(getAnnotations(method));
	}

	private List<Annotation> getAnnotations(ControllerMethod method) {
		Annotation[] methodAnnotations = method.getMethod().getAnnotations();
		Annotation[] resourceAnnotations = method.getController().getType().getAnnotations();

		List<Annotation> annotations = new ArrayList<Annotation>(Arrays.asList(methodAnnotations));
		annotations.addAll(Arrays.asList(resourceAnnotations));
		return annotations;
	}
}