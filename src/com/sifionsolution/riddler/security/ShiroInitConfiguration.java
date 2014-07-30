package com.sifionsolution.riddler.security;

import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import br.com.caelum.vraptor.security.strategy.ShiroInitConfigStrategy;

public class ShiroInitConfiguration implements ShiroInitConfigStrategy {
	@Override
	public void init(DefaultWebSecurityManager securityManager, AuthorizingRealm realm) {
		realm.setCredentialsMatcher(new PasswordMatcher());
	}
}
