package com.sifionsolution.riddler.converter;

import static com.sifionsolution.commons.util.ContentVerifyer.isEmpty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.TwoWayConverter;

import com.sifionsolution.riddler.model.Riddle;
import com.sifionsolution.riddler.model.dao.RiddleDAO;

@Convert(Riddle.class)
@RequestScoped
public class RiddleConverter implements TwoWayConverter<Riddle> {

	@Inject
	private RiddleDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(RiddleConverter.class);

	@Override
	public Riddle convert(String value, Class<? extends Riddle> type) {
		if (isEmpty(value)) {
			logger.debug("Can´t convert empty String => Riddle. Returning null");
			return null;
		}

		try {
			Long id = Long.valueOf(value);
			return dao.find(id);
		} catch (Exception e) {
			logger.error("Couldnt convert Riddle", e);
		}

		return null;
	}

	@Override
	public String convert(Riddle value) {
		if (value == null) {
			logger.debug("Can´t convert null Riddle. Returning null");
			return null;
		}

		return String.valueOf(value.getId());
	}

}
