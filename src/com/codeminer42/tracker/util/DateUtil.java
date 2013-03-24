package com.codeminer42.tracker.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.inject.Inject;

/**
 * @author clertonleal@gmail.com
 * @since 24/03/2013
 */
public class DateUtil {

	@Inject
	private SimpleDateFormat dateFormater;
	
	public void setPattern(final String pattern){
		dateFormater.applyPattern(pattern);
	}
	
	public String getFormatedDate(final Date date){
		return dateFormater.format(date);
	}
	
	public String getFormatedDate(final int year, final int month, final int day){
		return getFormatedDate(getDate(year, month, day));
	}
	
	public Date getDate(final int year, final int month, final int day){
		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		return calendar.getTime();
	}
	
}
