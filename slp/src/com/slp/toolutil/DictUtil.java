package com.slp.toolutil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DictUtil {

	// [start]私有函数
	private static String getDictValueFromMap(Map<String, String> map,
			String key) {
		String value = "";
		Set<String> set = map.keySet();

		for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
			if (iter.next().equals(key)) {
				value = (String) map.get(key);
			}
		}
		return value;
	}

	// [end]

	// [start]常用函数
	public static String getClaimResult(String key) {
		return getDictValueFromMap(claimResultDict(), key);
	}

	public static String getauditorType(String key) {
		return getDictValueFromMap(auditorTypeDict(), key);
	}
	
	public static String GetauditorType(String status) {
		return getDictValueFromMap(auditorTypeDict(), status);
	}

	// [end]

	// [start]字典
	public static Map<String, String> claimResultDict() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("1", "通过");
		result.put("2", "退回");
		result.put("3", "拒赔");
		result.put("4", "提交调度");
		return result;
	}

	public static Map<String, String> auditorTypeDict() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("1", "第一级");
		result.put("2", "第二级");
		result.put("3", "第三级");
		result.put("4", "第四级");
		result.put("5", "第五级");
		result.put("6", "第六级");
		result.put("7", "第七级");
		result.put("8", "第八级");
		result.put("9", "第九级");
		result.put("10", "第十级");
		return result;

	}
	
	//索赔员意见
	public static Map<String, String> claimStatusDict() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("1", "正常");
		result.put("2", "拒赔");
		return result;
	}
	
	// [end]
	
}
