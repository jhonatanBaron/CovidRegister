package com.uptc.prg2.CovidRegister.persistence.utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class UtilitiesFiles {

	public static final String SPLIT_CHARACTER = "\\?+";
	public static final String SPLIT_DATE_CHARACTER = "/+";
	public static final String SPLIT_TIME_CHARACTER = ":+";

	public String[] splitDate(String date) {
		return date.split(SPLIT_DATE_CHARACTER);
	}

	public String[] splitTime(String date) {
		return date.split(SPLIT_TIME_CHARACTER);
	}

	public Calendar sendDate(String[] date) {
		Calendar dateV = Calendar.getInstance();
		dateV.set(Integer.parseInt(date[2]),
				Integer.parseInt(date[0]) - 1,
				Integer.parseInt(date[1]));
		return dateV;
	}

	public Calendar sendTime(String[] record) {
		Calendar time = Calendar.getInstance();
		time.set(0, 0, 0, Integer.parseInt(record[0]),
				Integer.parseInt(record[1]),
				Integer.parseInt(record[2]));
		return time;
	}

	public static Calendar parseDateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static LocalDate parseDateToLocalDate(
			Date date) {
		return date.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

	public static String toStringCalendar(
			Calendar calendar) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/YYYY");
		return simpleDateFormat.format(calendar.getTime());

	}

	public static String toDecimalFormat(double value) {
		DecimalFormat df = (DecimalFormat) NumberFormat
				.getInstance();
		df.applyPattern("###########,###.## $");
		String strValue = df.format(value);
		return strValue;
	}

	public static String toDecimalFormatNegative(
			double value) {
		DecimalFormat df = (DecimalFormat) NumberFormat
				.getInstance();
		df.applyPattern("- ###########,###.## $");
		String strValue = df.format(value);
		return strValue;
	}

	public static String[] splitLine(String line) {
		return line.split(SPLIT_CHARACTER);
	}

	public static Date ParseFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat(
				"dd/MM/yyyy");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} catch (ParseException ex) {
		}
		return fechaDate;
	}

	public static LocalDate parseStringToLocalDate(
			String date) {
		LocalDate localDate = LocalDate.parse(date,
				DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return localDate;
	}

//	public static Gender getGender(String genderStr) {
//		switch (genderStr) {
//		case "FEMENINO":
//			return Gender.FEMENINO;
//		case "MASCULINO":
//			return Gender.MASCULINO;
//		default:
//			return Gender.FEMENINO;
//		}
//	}

	public static String toStringSeparator(
			Object[] object) {
		String line = "";
		for (Object object2 : object) {
			line += object2 + "-";
		}
		return line;

	}
}