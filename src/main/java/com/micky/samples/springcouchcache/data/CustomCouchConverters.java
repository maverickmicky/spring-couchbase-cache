package com.micky.samples.springcouchcache.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.util.StringUtils;


public final class CustomCouchConverters {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private CustomCouchConverters() {}

	/**
	 * Returns the converters to be registered.
	 * 
	 */
	public static List<Object> getConvertersToRegister() {

		List<Object> converters = new ArrayList<Object>();

		converters.add(BigDecimalToStringConverter.INSTANCE);
		converters.add(StringToBigDecimalConverter.INSTANCE);
		converters.add(IntegerToStringConverter.INSTANCE);
		converters.add(StringToIntegerConverter.INSTANCE);

		return converters;
	}

	@WritingConverter
	public static enum BigDecimalToStringConverter implements Converter<BigDecimal, String> {
		INSTANCE;

		public String convert(BigDecimal source) {
			source = source.setScale(2, RoundingMode.CEILING);
			return source == null ? null : source.toString();
		}
	}

	@ReadingConverter
	public static enum StringToBigDecimalConverter implements Converter<String, BigDecimal> {
		INSTANCE;

		public BigDecimal convert(String source) {
			return StringUtils.hasText(source) ? new BigDecimal(source) : null;
		}
	}

	@WritingConverter
	public static enum IntegerToStringConverter implements Converter<Integer, String> {
		INSTANCE;

		public String convert(Integer source) {
			return source == null ? null : source.toString();
		}
	}

	@ReadingConverter
	public static enum StringToIntegerConverter implements Converter<String, Integer> {
		INSTANCE;

		public Integer convert(String source) {
			return StringUtils.hasText(source) ? new Integer(source) : null;
		}
	}
	
}
