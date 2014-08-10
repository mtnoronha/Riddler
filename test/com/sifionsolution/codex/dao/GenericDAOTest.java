package com.sifionsolution.codex.dao;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sifionsolution.codex.dao.GenericDAO;
import com.sifionsolution.codex.dao.parameters.HqlParameter;
import com.sifionsolution.codex.model.User;

public class GenericDAOTest {

	@Mock
	private EntityManager em;

	@Mock
	private Query query;

	private GenericDAO<Long, User> dao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		when(em.createQuery(anyString())).thenReturn(query);
		dao = new GenericDAO<Long, User>(User.class, em);
	}

	@Test
	public void shouldAddParameters() {
		HqlParameter hqlParameter = new HqlParameter("attribute", "value");
		HqlParameter spy = spy(hqlParameter);

		doNothing().when(spy).apply(query);
		dao.listByHql("HQL", spy);

		verify(spy).apply(query);
	}

}
