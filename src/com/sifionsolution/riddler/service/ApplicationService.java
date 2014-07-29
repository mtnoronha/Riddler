package com.sifionsolution.riddler.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sifionsolution.riddler.enums.Config;

@ApplicationScoped
public class ApplicationService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	private ServletContext context;

	public String getURI(String dir) {
		if (dir == null)
			dir = "";

		String uri = context.getInitParameter("vraptor.reports.path");
		return context.getRealPath(uri != null ? uri.trim() : "WEB-INF") + dir;
	}

	public Properties getProperties(String propertyLocation) {
		try {
			Properties prop = new Properties();
			InputStream in = new FileInputStream(getURI(propertyLocation));
			prop.load(in);
			in.close();

			return prop;
		} catch (Exception e) {
			logger.error("Unable to get properties file.", e);
			throw new RuntimeException(e);
		}
	}

	public Properties getConfig(Config config) {
		return getProperties(config.getPath());
	}
}