package com.sunjays.capl.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {
	@Override
	public Date convert(String s) {
		SimpleDateFormat sdf = null;
		try {
			if (s.contains(":")) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(s);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
}
