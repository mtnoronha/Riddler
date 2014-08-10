package com.sifionsolution.codex.dao.parameters;

import static org.mockito.Mockito.verify;

import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sifionsolution.codex.dao.parameters.HqlParameter;

public class HqlParameterTest {

	@Mock
	private Query query;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldSetToQuery() {
		new HqlParameter("", "").apply(query);

		verify(query).setParameter("", "");

	}

	@Test
	public void shouldNotSetToQuery() {
		new HqlParameter("", "").apply(null);

	}
}
