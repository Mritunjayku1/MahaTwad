/**
 * 
 */
package com.water.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mahalingam
 * 
 *         This class contains common methods accessible over the application
 * 
 */
public class Common {

	private static final String ALPHA_NUMERIC_STRING = "0123456789";

	/**
	 * @param length
	 *            -- required length of string
	 * @return String - random alphanumeric string based on the required length
	 * 
	 *         For unique user token
	 */
	public static String getComplaintNo(int length) {
		StringBuilder builder = new StringBuilder();
		while (length-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING
					.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	public static String getSysDate() {
		Date date = new Date();
		return new SimpleDateFormat("dd-MM-yyyy").format(date);
	}

	public static String convertDateFormat(String ddmmYYYYY) {
		if (ddmmYYYYY != null && !"".equals(ddmmYYYYY)) {
			String[] datePart = ddmmYYYYY.split("-");
			ddmmYYYYY = datePart[2] + "-" + datePart[1] + "-" + datePart[0];
			return ddmmYYYYY;
		} else {
			return convertDateFormat(getSysDate());
		}
	}

	public static Date getDate() {
		return new Date();

	}

	public static Date convertDate(String ddmmYYYYHHmmss) {
		Date date = null;
		// System.out.println(ddmmYYYYHHmmss);
		if (ddmmYYYYHHmmss != null && !"".equals(ddmmYYYYHHmmss)
				&& !"null".equalsIgnoreCase(ddmmYYYYHHmmss))
			try {
				date = new java.util.Date();
				// 10-06-2017 00:00,
				ddmmYYYYHHmmss = ddmmYYYYHHmmss.substring(0, 16);
				String datePart = ddmmYYYYHHmmss.split(" ")[0];
				String timePart = ddmmYYYYHHmmss.split(" ")[1];
				ddmmYYYYHHmmss = convertDateFormat(datePart) + " " + timePart
						+ ":00";
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(ddmmYYYYHHmmss);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return date;
	}

	public static String convertDate(Date YYYYmmddHHmmss) {
		String strDate = "";
		if (YYYYmmddHHmmss != null) {

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

			strDate = dateFormat.format(YYYYmmddHHmmss);
			strDate = convertDateFormat(strDate.split(" ")[0]) + " "
					+ strDate.split(" ")[1];

		}
		return strDate;

	}

	public static Date convertDBDate(String YYYYmmddHHmmss) {
		Date date = null;
		if (YYYYmmddHHmmss != null) {
			try {
				date = new SimpleDateFormat("yyyy-MM-dd hh:mm")
						.parse(YYYYmmddHHmmss);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;

	}

}
