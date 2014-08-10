package com.sifionsolution.codex.database;

import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_DRIVER;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_PASSWORD;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_URL;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_USER;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.environment.Environment;

import com.googlecode.flyway.core.Flyway;
import com.sifionsolution.codex.enums.Config;
import com.sifionsolution.codex.service.ApplicationService;

/**
 * An {@link EntityManager} producer, that creates an instance for each request.
 * 
 * @author Lucas Cavalcanti
 * @author Otávio Garcia
 */
public class EntityManagerFactoryCreator {

	@Inject
	private Environment environment;

	@Inject
	private ApplicationService service;

	@ApplicationScoped
	@Produces
	public EntityManagerFactory getEntityManagerFactory() {
		String persistenceUnit = environment.get("br.com.caelum.vraptor.jpa.persistenceunit", "default");

		// Database configuration
		Properties configs = service.getConfig(Config.DATABASE);
		String user = configs.getProperty("user");
		String pass = configs.getProperty("pass");
		String url = configs.getProperty("url");

		// Migrate database
		Flyway flyway = new Flyway();

		flyway.setDataSource(url, user, pass);
		flyway.setLocations("script");

		flyway.migrate();

		// Create Entity Manager Factory
		Map<String, String> props = createFactoryProperties(configs, user, pass, url);
		return Persistence.createEntityManagerFactory(persistenceUnit, props);

	}

	public void destroy(@Disposes EntityManagerFactory factory) {
		if (factory.isOpen()) {
			factory.close();
		}
	}

	private Map<String, String> createFactoryProperties(Properties configs, String user, String pass, String url) {
		Map<String, String> props = new HashMap<String, String>();

		props.put(JDBC_USER, user);
		props.put(JDBC_PASSWORD, pass);
		props.put(JDBC_DRIVER, configs.getProperty("driver"));
		props.put(JDBC_URL, url);
		return props;
	}
}
