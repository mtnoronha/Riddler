package com.sifionsolution.riddler.converter;

import static com.sifionsolution.commons.ContentVerifyer.isEmpty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.TwoWayConverter;

import com.sifionsolution.riddler.model.RiddleTest;
import com.sifionsolution.riddler.model.dao.RiddleTestDAO;

@Convert(RiddleTest.class)
@RequestScoped
public class RiddleTestConverter implements TwoWayConverter<RiddleTest> {

	@Inject
	private RiddleTestDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(RiddleTestConverter.class);

	@Override
	public RiddleTest convert(String value, Class<? extends RiddleTest> type) {
		if (isEmpty(value)) {
			logger.debug("Can´t convert empty String => RiddleTest. Returning null");
			return null;
		}

		try {
			Long id = Long.valueOf(value);
			return dao.find(id);
		} catch (Exception e) {
			logger.error("Couldnt convert RiddleTest", e);
		}

		return null;
	}

	@Override
	public String convert(RiddleTest value) {
		if (value == null) {
			logger.debug("Can´t convert null RiddleTest. Returning null");
			return null;
		}

		return String.valueOf(value.getId());
	}

}
