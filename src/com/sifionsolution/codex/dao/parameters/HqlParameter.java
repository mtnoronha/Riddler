package com.sifionsolution.codex.dao.parameters;

import javax.persistence.Query;

public class HqlParameter {
	private final String attribute;
	private final Object value;

	public HqlParameter(String attribute, Object value) {
		this.attribute = attribute;
		this.value = value;
	}

	public void apply(Query query) {
		if (query != null)
			query.setParameter(attribute, value);
	}

}
