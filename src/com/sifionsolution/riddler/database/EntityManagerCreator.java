package com.sifionsolution.riddler.database;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * An {@link EntityManager} producer, that creates an instance for each request.
 * 
 * @author Lucas Cavalcanti
 * @author Otávio Garcia
 */
public class EntityManagerCreator {

	private final EntityManagerFactory factory;

	/**
	 * @deprecated CDI eyes only.
	 */
	@Deprecated
	protected EntityManagerCreator() {
		this(null);
	}

	@Inject
	public EntityManagerCreator(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public void destroy(@Disposes EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}

}
