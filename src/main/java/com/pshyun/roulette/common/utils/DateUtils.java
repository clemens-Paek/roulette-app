package com.pshyun.roulette.common.utils;

import java.util.Calendar;

public class DateUtils {

	/**
	 * "yyyy-MM-dd"형식의 현재 날짜를 구한다.
	 * 
	 * @return
	 */
	public static String getDateString() {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
		return formatter.format(new java.util.Date());
	}

	/**
	 * "yyyy-MM-dd hh:mm:ss"형식의 현재 날짜를 구한다.
	 * 
	 * @return
	 */
	public static String getDateTimeString() {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.KOREA);
		return formatter.format(new java.util.Date());
	}

	/**
	 * date string 을 입력받아 올바른 날짜인지 체크하고 바른 형식이라면 입력된 새로운 format 으로 date string 을
	 * parsing하여 리턴한다.
	 * 
	 * @param strDate
	 *            String date string
	 * @param oldFormat
	 *            String old date string format
	 * @param newFormat
	 *            String new date string format
	 * @last updated 2002.04.18
	 */

	/**
	 * 주어진 날짜의 날짜 형식을 새로운 날짜 형식으로 변경한다.
	 * 
	 * @param strDate
	 *            변경할 날짜
	 * @param oldFormat
	 *            이전 날짜 형식
	 * @param newFormat
	 *            새로운 날짜 형식
	 * @return
	 * @throws java.text.ParseException
	 */
	public static String reFormat(String strDate, String oldFormat, String newFormat) throws java.text.ParseException {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(oldFormat, java.util.Locale.KOREA);
		java.util.Date date = null;

		try {
			date = formatter.parse(strDate);
		} catch (java.text.ParseException e) {
			throw new java.text.ParseException("You inputed wrong date:\"" + strDate + "\" with format \"" + oldFormat + "\"", 0);
		}

		if (!formatter.format(date).equals(strDate)) {
			throw new java.text.ParseException("You inputed wrong date:\"" + strDate + "\" with format \"" + oldFormat + "\"", 0);
		}
		formatter = new java.text.SimpleDateFormat(newFormat, java.util.Locale.KOREA);

		return formatter.format(date);
	}

	/**
	 * 년도를 얻는다.
	 * 
	 * @param date
	 *            String
	 * @return int
	 */
	public static int getYear(String date) {
		return Integer.parseInt(date.substring(0, 4));
	}

	/**
	 * 달을 얻는다.
	 * 
	 * @param date
	 *            String
	 * @return int
	 */
	public static int getMonth(String date) {
		date = date.replaceAll("-", "");
		return Integer.parseInt(date.substring(4, 6));
	}

	/**
	 * 일을 얻는다.
	 * 
	 * @param date
	 *            String
	 * @return int
	 */
	public static int getDay(String date) {
		date = date.replaceAll("-", "");
		return Integer.parseInt(date.substring(6, 8));
	}

	/**
	 * 현재 일에 해당되는 요일을 구한다.
	 * 
	 * @param _year
	 *            int
	 * @param _month
	 *            int
	 * @param _day
	 *            int
	 * @return int Day Of WEEK
	 */
	public static int getDayOfWeek(int _year, int _month, int _day) {
		Calendar cal = Calendar.getInstance();
		cal.set(_year, _month - 1, _day);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * "yyyy-MM-dd HH:mm:ss" 을 넘겨 받아서 해당 날짜가 무슨 요일인지를 return 한다.
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(String date) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(getYear(date), getMonth(date) - 1, getDay(date));
		int yoil = rightNow.get(Calendar.DAY_OF_WEEK); // 현재 요일
		return yoil;
	}

	/**
	 * 해당 날짜에 속하는 주의 월요일 날을 구한다.
	 * 
	 * @param date
	 *            String
	 * @return String Date
	 */
	public static String getMondayDate(String date) {
		String startDate;

		int year = getYear(date);
		int month = getMonth(date);
		int day = getDay(date);

		// 현재 날에 해당되는 요일을 구한다.
		int curDayOfWeek = getDayOfWeek(year, month, day);

		// 현재 날에 Add할 숫자를 구한다.
		int startTmp = 2 - curDayOfWeek;

		if (startTmp == 0) {
			return date;
		}
		if (startTmp > 0) {
			startTmp = startTmp - 7;
		}

		Calendar tmpCalendar = Calendar.getInstance();

		// 해당 Week의 첫번째 날을 구한다.
		tmpCalendar.set(year, month - 1, day);

		tmpCalendar.add(Calendar.DATE, startTmp);

		startDate = Integer.toString(tmpCalendar.get(Calendar.YEAR));

		if ((tmpCalendar.get(Calendar.MONTH) + 1) < 10) {
			startDate += "0";
		}
		startDate += Integer.toString((tmpCalendar.get(Calendar.MONTH)) + 1);

		if (tmpCalendar.get(Calendar.DATE) < 10) {
			startDate += "0";
		}
		startDate += Integer.toString(tmpCalendar.get(Calendar.DATE));

		return startDate;
	}

	/**
	 * 해당 날짜에 속하는 주의 일요일 날짜를 구한다.
	 * 
	 * @param date
	 *            String
	 * @return String Date
	 */
	public static String getSundayDate(String date) {
		String endDate;

		int year = getYear(date);
		int month = getMonth(date);
		int day = getDay(date);

		// 현재 날에 해당되는 요일을 구한다.
		int curDayOfWeek = getDayOfWeek(year, month, day);

		// 현재 날에 Add할 숫자를 구한다.
		int endTmp = 8 - curDayOfWeek;

		if (endTmp >= 7) {
			endTmp -= 7;
		}

		Calendar tmpCalendar = Calendar.getInstance();
		// 해당 Week의 마지막 날을 구한다.
		tmpCalendar.set(year, month - 1, day);
		tmpCalendar.add(Calendar.DATE, endTmp);
		endDate = Integer.toString(tmpCalendar.get(Calendar.YEAR));
		if ((tmpCalendar.get(Calendar.MONTH) + 1) < 10) {
			endDate += "0";
		}
		endDate += Integer.toString((tmpCalendar.get(Calendar.MONTH)) + 1);
		if (tmpCalendar.get(Calendar.DATE) < 10) {
			endDate += "0";
		}
		endDate += Integer.toString(tmpCalendar.get(Calendar.DATE));

		return endDate;
	}
}
