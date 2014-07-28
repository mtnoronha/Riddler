package com.sifionsolution.riddler.database;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.environment.Environment;

/**
 * An {@link EntityManager} producer, that creates an instance for each request.
 * 
 * @author Lucas Cavalcanti
 * @author OtÃ¡vio Garcia
 */
public class EntityManagerFactoryCreator {

	@Inject
	private Environment environment;

	@ApplicationScoped
	@Produces
	public EntityManagerFactory getEntityManagerFactory() {
		String persistenceUnit = environment.get("br.com.caelum.vraptor.jpa.persistenceunit", "default");
		return Persistence.createEntityManagerFactory(persistenceUnit);
	}

	public void destroy(@Disposes EntityManagerFactory factory) {
		if (factory.isOpen()) {
			factory.close();
		}
	}
}
