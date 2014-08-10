package com.sifionsolution.codex.security;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sifionsolution.codex.security.AccessService;
import com.sifionsolution.codex.security.AllowTo;
import com.sifionsolution.codex.security.UserWeb;

public class AccessServiceTest {

	@Mock(name = "userWeb")
	UserWeb userWeb;

	@InjectMocks
	AccessService service;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnTrueIfListIsEmpty() {
		assertTrue(service.canAccess(new ArrayList<Annotation>()));
	}

	@Test
	public void shouldCheckIfUserHasAccessWhenAnnotationIsAllowTo() {
		AccessService spy = spy(service);
		doReturn(false).when(spy).containsAnyFeature(any(Annotation.class));

		Annotation allow = mock(AllowTo.class);

		spy.canAccess(Arrays.asList(allow));

		verify(spy).containsAnyFeature(allow);
	}

	@Test
	public void shouldReturnTrueIfNoneAnnotationIsAllowToTyped() {
		AccessService spy = spy(service);
		Annotation allow = mock(Annotation.class);

		boolean canAccess = spy.canAccess(Arrays.asList(allow));

		verify(spy, never()).containsAnyFeature(allow);
		assertTrue(canAccess);
	}

}
