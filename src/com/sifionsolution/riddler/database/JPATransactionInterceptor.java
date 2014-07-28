package br.com.caelum.vraptor.util;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.http.MutableResponse;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.validator.Validator;

/**
 * An interceptor that manages Entity Manager Transaction. All requests are intercepted
 * and a transaction is created before execution. If the request has no erros, the transaction
 * will commited, or a rollback occurs otherwise.
 * 
 * @author Lucas Cavalcanti
 */
@Intercepts
public class JPATransactionInterceptor {

	private final EntityManager manager;
	private final Validator validator;
	private final MutableResponse response;

	/**
	 * @deprecated CDI eyes only.
	 */
	protected JPATransactionInterceptor() {
		this(null, null, null);
	}
	
	@Inject
	public JPATransactionInterceptor(EntityManager manager, Validator validator, MutableResponse response) {
		this.manager = manager;
		this.validator = validator;
		this.response = response;
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		
		addRedirectListener();
		
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			stack.next();
			
			commit(transaction);
			
		} finally {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	private void commit(EntityTransaction transaction) {
		if (!validator.hasErrors() && transaction.isActive()) {
			transaction.commit();
		}
	}

	/**
	 * We force the commit before the redirect, this way we can abort the
	 * redirect if a database error occurs.
	 */
	private void addRedirectListener() {
		response.addRedirectListener(new MutableResponse.RedirectListener() {
			@Override
			public void beforeRedirect() {
				commit(manager.getTransaction());
			}
		});
	}
}
