package com.sifionsolution.riddler.database.converter;

import java.sql.Timestamp;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.DateTime;

@Converter(autoApply = true)
public class JpaDateTimeConverter implements AttributeConverter<DateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(DateTime objectValue) {
		return objectValue == null ? null : new Timestamp(objectValue.getMillis());
	}

	@Override
	public DateTime convertToEntityAttribute(Timestamp dataValue) {
		return dataValue == null ? null : new DateTime(dataValue);
	}

}
