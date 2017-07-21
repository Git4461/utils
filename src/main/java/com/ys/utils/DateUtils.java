package com.ys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 日期工具
 * 
 * @author 余帅
 *
 */
public class DateUtils {

	public enum Pattern {
		PATTERN_0("yyyy-MM-dd HH:mm:ss"), PATTERN_1("yyyyMMddHHmmss");

		private String value;

		Pattern(String v) {
			this.value = v;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 获取系统时间yyyyMMddHHmmss
	 * 
	 * **/
	public static String getSysTime() {
		return getSysTime(Pattern.PATTERN_1);
	}

	/**
	 * 获取系统时间yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getSysTimeStand() {
		return getSysTime(Pattern.PATTERN_0);
	}

	public static String getSysTime(Pattern p) {
		SimpleDateFormat df = new SimpleDateFormat(p.getValue());
		Date curDate = new Date();// 获取当前时间
		String str = df.format(curDate);
		return str;
	}

	/**
	 * 获取某年的每月
	 * 
	 * @param year
	 *            2017
	 * @return 集合(1,2,3..)
	 * @throws ParseException
	 */
	public static List<String> getEveryMonthByYear(String year)
			throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		List<String> list = new ArrayList<String>();
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(simpleDateFormat2.parse(year));
		int maxDay = calendar.getActualMaximum(Calendar.MONTH);
		int minDay = calendar.getActualMinimum(Calendar.MONTH);
		for (int i = minDay; i <= maxDay; i++) {
			calendar.set(Calendar.MONTH, i);
			list.add(simpleDateFormat.format(calendar.getTime()));
		}
		return list;
	}

	/**
	 * 获取月的每天
	 * 
	 * @param month
	 *            201706
	 * @return 集合（1,2,3,4,5...）
	 * @throws ParseException
	 */
	public static List<String> getEveryDayByMonth(String month)
			throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		List<String> list = new ArrayList<String>();
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(simpleDateFormat2.parse(month));
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int minDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		for (int i = minDay; i <= maxDay; i++) {
			calendar.set(Calendar.DAY_OF_MONTH, i);
			list.add(simpleDateFormat.format(calendar.getTime()));
		}
		return list;
	}

	/**
	 * 加或减 年
	 * 
	 * @param dateStr
	 * @param amount
	 * @param p
	 *            dateStr的格式
	 * @return
	 * @throws ParseException
	 */
	public static String changeYear(String dateStr, int amount, Pattern p)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(p.getValue());
		Date date = sdf.parse(dateStr);
		Calendar calendar1 = new GregorianCalendar();
		calendar1.setTime(date);
		calendar1.add(Calendar.YEAR, amount);
		return sdf.format(calendar1.getTime());
	}

	/**
	 * 加或减 月
	 * 
	 * @param dateStr
	 * @param amount
	 * @param p
	 *            dateStr的格式
	 * @return
	 * @throws ParseException
	 */
	public static String changeMonth(String dateStr, int amount, Pattern p)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(p.getValue());
		Date date = sdf.parse(dateStr);
		Calendar calendar1 = new GregorianCalendar();
		calendar1.setTime(date);
		calendar1.add(Calendar.MONTH, amount);
		return sdf.format(calendar1.getTime());
	}

	/**
	 * 加或减 天
	 * 
	 * @param dateStr
	 * @param amount
	 * @param p
	 *            dateStr的格式
	 * @return
	 * @throws ParseException
	 */
	public static String changeDay(String dateStr, int amount, Pattern p)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(p.getValue());
		Date date = sdf.parse(dateStr);
		Calendar calendar1 = new GregorianCalendar();
		calendar1.setTime(date);
		calendar1.add(Calendar.DAY_OF_MONTH, amount);
		return sdf.format(calendar1.getTime());
	}

	/**
	 * 加或减小时
	 * 
	 * @param dateStr
	 * @param amount
	 * @param p
	 *            dateStr的格式
	 * @return
	 * @throws ParseException
	 */
	public static String changeHour(String dateStr, int amount, Pattern p)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(p.getValue());
		Date date = sdf.parse(dateStr);
		Calendar calendar1 = new GregorianCalendar();
		calendar1.setTime(date);
		calendar1.add(Calendar.HOUR_OF_DAY, amount);
		return sdf.format(calendar1.getTime());
	}

	/**
	 * 加或减分钟
	 * 
	 * @param dateStr
	 * @param amount
	 * @param p
	 *            dateStr的格式
	 * @return
	 * @throws ParseException
	 */
	public static String changeMinute(String dateStr, int amount, Pattern p)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(p.getValue());
		Date date = sdf.parse(dateStr);
		Calendar calendar1 = new GregorianCalendar();
		calendar1.setTime(date);
		calendar1.add(Calendar.MINUTE, amount);
		return sdf.format(calendar1.getTime());
	}

	/**
	 * 将日期从一个格式转换到另一个格式
	 * 
	 * @param pattern
	 *            转换前格式
	 * @param pattern_to
	 *            转换后格式
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String converDate(Pattern pattern, Pattern pattern_to,
			String dateStr) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat(pattern.getValue());
		Date parse = sdf.parse(dateStr);
		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern_to.getValue());
		return sdf2.format(parse);
	}
}
