package com.example.demo.date;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.format.Formatter;

/**
 * @author Hyman
 *      用来转换本地时间格式
 *
 */
public class CNLocalDateFormatter implements Formatter<LocalDate> {

	public static final String CN_PATTERN = "yyyy-MM-dd";
	public static final String NORMAL_PATTERN = "dd/MM/yyyy";

	@Override
	public String print(LocalDate object, Locale locale) {

		return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {

		return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
	}

	public static String getPattern(Locale locale) {
		return isCN(locale) ? CN_PATTERN : NORMAL_PATTERN;
	}

	private static boolean isCN(Locale locale) {
		return Locale.CHINA.getCountry().equals(locale.getCountry());
	}
}
