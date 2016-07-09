package com.fdc.admin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateService {
	private static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd-hh-mm");

	public static Calendar string2Date(String dateString) {
		Calendar calendar;
		try {
			calendar = Calendar.getInstance();
			calendar.setTime(format.parse(dateString));			
		} catch(ParseException parseException) {
			calendar = null;
			System.err.println(parseException.getMessage());
		}
		return calendar;
	}

	public static String date2String(Calendar calendar) {
		return format.format(calendar.getTime());
	}

	public static String nowDateString() {
		return date2String(Calendar.getInstance());
	}
}
