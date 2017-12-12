package com.slp.toolutil;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.google.gson.Gson;

public class ToolUtil {

	public static String GetMD5Code(String s) {
		byte[] hash;
		try {
			hash = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Huh, UTF-8 should be supported?", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10)
				hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		return hex.toString();
	}

	public static String GetString(Object o) {
		String result = "";
		if (null == o) {
			return result;
		}
		result = o.toString().trim();
		return result;
	}

	public static boolean IsEmptyOrNull(String s) {
		if (null == s) {
			return true;
		}
		s = s.trim();
		if (s.length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean IsIdCard(String idcard) {
		return IdcardUtils.validateCard(idcard);
	}

	public static String GetRandId() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String result = sdf.format(now);
		result += String.valueOf(Math.random()).substring(2, 8);
		return result;
	}

	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24);
	}

	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {

		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {

			}
		}
		return result;
	}

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("Charsert", "UTF-8");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			// in = new BufferedReader(new InputStreamReader(
			// connection.getInputStream()));
			// String line;
			// while ((line = in.readLine()) != null) {
			// result += line;
			// }
			InputStream inputStream = connection.getInputStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			try {
				while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
					out.write(buffer, 0, len);
				}
				// 将内存流转换为字符串
				result = new String(out.toByteArray());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		result = result.trim();
		return result;
	}

	public static String GetJsonFromObject(Object item) {
		Gson gs = new Gson();
		return gs.toJson(item);
	}

	// 将汉字转换为全拼
	public static String getPingYin(String src) {

		char[] t1 = null;
		t1 = src.toCharArray();
		String[] t2 = new String[t1.length];
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				// 判断是否为汉字字符
				if (java.lang.Character.toString(t1[i]).matches(
						"[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					t4 += t2[0];
				} else
					t4 += java.lang.Character.toString(t1[i]);
			}
			// System.out.println(t4);
			return t4;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return t4;
	}

	// 返回中文的首字母
	public static String getPinYinHeadChar(String str) {
		String temp = "";
		String demo = "";
		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		for (int i = 0; i < convert.length(); i++) {// convert目前为小写首字母,下面是将小写首字母转化为大写
			if (convert.charAt(i) >= 'a' && convert.charAt(i) <= 'z') {
				temp = convert.substring(i, i + 1).toUpperCase();
				demo += temp;
			}
		}
		return demo;
	}

	// 将字符串转移为ASCII码
	public static String getCnASCII(String cnStr) {
		StringBuffer strBuf = new StringBuffer();
		byte[] bGBK = cnStr.getBytes();
		for (int i = 0; i < bGBK.length; i++) {
			// System.out.println(Integer.toHexString(bGBK[i]&0xff));
			strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
		}
		return strBuf.toString();
	}

	/**
	 * @Description:判断是否是邮件格式
	 * @Author: 老史
	 * @Version: V1.00
	 * @Create Date: 2017年3月2日 下午3:39:55
	 * @Parameters:
	 */
	public static boolean isEmail(String str) {
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 验证某字符串是否符合手机格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {
		String regular = "1[3,4,5,8]{1}\\d{9}";
		Pattern pattern = Pattern.compile(regular);
		boolean flag = false;
		if (str != null) {
			Matcher matcher = pattern.matcher(str);
			flag = matcher.matches();
		}
		return flag;
	}

	/**
	 * @Description:深度复制
	 * @Author: 老史
	 * @Version: V1.00
	 * @Create Date: 2017年3月2日 下午3:39:55
	 * @Parameters:
	 */
	public static void BeanCopy(Object source, Object target, boolean isCopyNull) {

		if (null == source || null == target) {
			return;
		}

		Class<?> sourceClazz = source.getClass();
		Class<?> targetClazz = target.getClass();
		Field[] fields = targetClazz.getDeclaredFields(); // 取到所有类下的属性，也就是变量名
		Field field;

		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			String fieldName = field.getName();
			// 把属性的第一个字母处理成大写
			String stringLetter = fieldName.substring(0, 1).toUpperCase();
			// 取得setter方法名，比如setBbzt
			String setName = "set" + stringLetter + fieldName.substring(1);
			// 取得getter方法名
			String getName = "get" + stringLetter + fieldName.substring(1);
			// 真正取得get方法。
			Method setMethod = null;
			// 真正取得set方法
			Method sourceGetMethod = null;

			Class<?> fieldClass = field.getType();
			try {
				if (isHaveSuchMethod(targetClazz, setName)) {
					setMethod = targetClazz.getMethod(setName, fieldClass);
					if (isHaveSuchMethod(sourceClazz, getName)) {
						sourceGetMethod = sourceClazz.getMethod(getName);
					}
					Object sourceValue = sourceGetMethod.invoke(source);
					if (null != sourceValue) {
						setMethod.invoke(target, sourceValue);// 为其赋值
					} else {
						if (isCopyNull) {
							setMethod.invoke(target, sourceValue);
						}
					}
				}
			} catch (Exception e) {

			}
		}
		return;
	}

	/**
	 * @Description:深度复制
	 * @Author: 老史
	 * @Version: V1.00
	 * @Create Date: 2017年3月2日 下午3:39:55
	 * @Parameters:
	 */
	public static void BeanCopy(Object source, Object target) {

		if (null == source || null == target) {
			return;
		}

		Class<?> sourceClazz = source.getClass();
		Class<?> targetClazz = target.getClass();
		Field[] fields = targetClazz.getDeclaredFields(); // 取到所有类下的属性，也就是变量名
		Field field;

		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			String fieldName = field.getName();
			// 把属性的第一个字母处理成大写
			String stringLetter = fieldName.substring(0, 1).toUpperCase();
			// 取得setter方法名，比如setBbzt
			String setName = "set" + stringLetter + fieldName.substring(1);
			// 取得getter方法名
			String getName = "get" + stringLetter + fieldName.substring(1);
			// 真正取得get方法。
			Method setMethod = null;
			// 真正取得set方法
			Method sourceGetMethod = null;

			Class<?> fieldClass = field.getType();
			try {
				if (isHaveSuchMethod(targetClazz, setName)) {
					setMethod = targetClazz.getMethod(setName, fieldClass);
					if (isHaveSuchMethod(sourceClazz, getName)) {
						sourceGetMethod = sourceClazz.getMethod(getName);
					}
					Object sourceValue = sourceGetMethod.invoke(source);
					if (null != sourceValue) {
						setMethod.invoke(target, sourceValue);// 为其赋值
					}
				}
			} catch (Exception e) {

			}

		}

		// 需要取父类
		while (null != targetClazz.getSuperclass()) {
			fields = targetClazz.getSuperclass().getDeclaredFields();
			for (Field dfield : fields) {
				String fieldName = dfield.getName();
				// 把属性的第一个字母处理成大写
				String stringLetter = fieldName.substring(0, 1).toUpperCase();
				// 取得setter方法名，比如setBbzt
				String setName = "set" + stringLetter + fieldName.substring(1);
				// 取得getter方法名
				String getName = "get" + stringLetter + fieldName.substring(1);
				// 真正取得get方法。
				Method setMethod = null;
				// 真正取得set方法
				Method sourceGetMethod = null;

				Class<?> fieldClass = dfield.getType();
				try {
					if (isHaveSuchMethod(targetClazz, setName)) {
						setMethod = targetClazz.getMethod(setName, fieldClass);
						if (isHaveSuchMethod(sourceClazz, getName)) {
							sourceGetMethod = sourceClazz.getMethod(getName);
						}
						Object sourceValue = sourceGetMethod.invoke(source);
						if (null != sourceValue) {
							setMethod.invoke(target, sourceValue);// 为其赋值
						}
					}
				} catch (Exception e) {

				}

			}
			targetClazz = targetClazz.getSuperclass();
		}

		return;
	}

	/**
	 * 本方法封装了往前台设置的header,contentType等信息
	 * 
	 * @param message
	 *            需要传给前台的数据
	 * @param type
	 *            指定传给前台的数据格式,如"html","json"等
	 * @param response
	 *            HttpServletResponse对象
	 * @throws IOException
	 * @createDate 2010-12-31 17:55:41
	 */
	public static void writeToWeb(String message, String type,
			HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/" + type + "; charset=utf-8");
		response.getWriter().write(message);
		response.getWriter().close();
	}

	/**
	 * 判断某个类里是否有某个方法
	 * 
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	public static boolean isHaveSuchMethod(Class<?> clazz, String methodName) {
		Method[] methodArray = clazz.getMethods();
		boolean result = false;
		if (null != methodArray) {
			for (int i = 0; i < methodArray.length; i++) {
				if (methodArray[i].getName().equals(methodName)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	// TODO
	// 导入execel 获得每一行的所有值
	public static Map<String, String> creatObjectByRow(Row row) {
		// 行的所有列
		Iterator<Cell> cellBody = row.cellIterator();
		// 遍历一行的列
		int col = 1;
		Map<String, String> map = new HashMap<String, String>();
		while (cellBody.hasNext()) {
			String field = String.valueOf(col++);
			Cell cell = cellBody.next();
			if (cell != null) {
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING: // 字符
					map.put(field,
							ToolUtil.GetString(cell.getStringCellValue()));
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN: // 布尔
					map.put(field,
							ToolUtil.GetString(cell.getStringCellValue()));
					break;
				case HSSFCell.CELL_TYPE_NUMERIC: // 数字
					if (HSSFDateUtil.isCellDateFormatted(cell)) {// 是否为日期格式
						map.put(field, String.valueOf(cell.getDateCellValue()));
						// map.put(field,
						// DateUtil.GetFormatDateTime(cell.getDateCellValue()));
					} else {
						Double cellValue_dob = cell.getNumericCellValue();// 读取cell内数据
						if (String.valueOf(cellValue_dob).length() > 11) { // 如果读取到的是手机号码,需要匹配数字格式
						// DecimalFormat format = (DecimalFormat) NumberFormat
						// .getInstance();
							DecimalFormat format = new DecimalFormat("#");
							// format.applyPattern("00000000000");
							map.put(field, format.format(cellValue_dob));
						} else { // 如果读取到的是比较短的数字，则去掉尾数（.0）后显示
							map.put(field,
									cellValue_dob.toString()
											.substring(
													0,
													cellValue_dob.toString()
															.length() - 2));
						}
					}
					break;
				case HSSFCell.CELL_TYPE_FORMULA: // 公式
					map.put(field, String.valueOf(cell.getNumericCellValue()));
					break;
				case HSSFCell.CELL_TYPE_BLANK: // 空
					map.put(field,
							ToolUtil.GetString(cell.getStringCellValue()));
					break;
				case HSSFCell.CELL_TYPE_ERROR: // 异常
					map.put(field,
							ToolUtil.GetString(cell.getStringCellValue()));
					break;
				default:
					map.put(field,
							ToolUtil.GetString(cell.getStringCellValue()));
					break;
				}
			} else {
				map.put(field, "");
			}
		}
		return map;
	}

}
