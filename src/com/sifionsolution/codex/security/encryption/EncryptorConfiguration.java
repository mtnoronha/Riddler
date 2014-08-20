package com.sifionsolution.codex.security.encryption;

import javax.enterprise.context.ApplicationScoped;

import com.sifionsolution.vraptor.encryptor.configuration.Configuration;
import com.sifionsolution.vraptor.encryptor.configuration.EncryptorConfigurator;
import com.sifionsolution.vraptor.encryptor.implementation.Sha512Encryptor;
import com.sifionsolution.vraptor.encryptor.salter.implementation.ShuffleSalter;

@ApplicationScoped
public class EncryptorConfiguration implements EncryptorConfigurator {

	@Override
	public void configure(Configuration config) {
		config.map(PasswordEncryption.class, Sha512Encryptor.class, ShuffleSalter.class);
	}

}
