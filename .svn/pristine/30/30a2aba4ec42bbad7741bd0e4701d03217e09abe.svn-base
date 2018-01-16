package com.sunjays.capl.converter;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class Date2StringConverter implements Converter<Date, String> {
	@Override
	public String convert(Date date) {
		return DateFormat.getDateInstance().format(date);
	}
}
