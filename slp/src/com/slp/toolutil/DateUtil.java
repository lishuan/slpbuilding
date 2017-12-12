package com.slp.toolutil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static String getStarttime(String str) {
		if (ToolUtil.IsEmptyOrNull(str)) {
			return str;
		}
		return str + " 00:00:00";
	}

	public static String getEndtime(String str) {
		if (ToolUtil.IsEmptyOrNull(str)) {
			return str;
		}
		return str + " 23:59:59";
	}

	public static boolean isNumeric(String str) {
		if (ToolUtil.IsEmptyOrNull(str)) {
			return false;
		}
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static String GetString(Object o) {
		String result = "";
		if (o == null) {
			return result;
		}
		return o.toString();
	}

	public static int GetInt(Object o) {
		int defaultvalue = 0;
		return GetInt(o, defaultvalue);
	}

	public static int GetInt(Object o, int defaultvalue) {
		if (null == o) {
			return defaultvalue;
		}
		try {
			defaultvalue = Integer.parseInt(o.toString());
		} catch (Exception ex) {
			return defaultvalue;
		}
		return defaultvalue;
	}

	public static String GetStringFromDateTime(Object o) {
		try {
			String result = "";
			if (o == null) {
				return result;
			}

			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			result = format.format(format.parse(o.toString()));
			return result;
		} catch (Exception ex) {
		}
		return "";

	}

	public static String GetFormatDateTime(Object o) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String result = "";
			if (o == null) {
				Date now = new Date();
				result = format.format(now);
				return result;
			}
			result = format.format(format.parse(o.toString()));
			return result;
		} catch (Exception ex) {
		}
		return "";

	}

	public static String GetDateTime() {
		Date now = new Date();
		try {
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat format = new SimpleDateFormat(pattern,
					Locale.CHINESE);
			return format.format(now);
		} catch (Exception e) {
			return "";
		}
	}

}
