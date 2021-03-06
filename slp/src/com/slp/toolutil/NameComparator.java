package com.slp.toolutil;

import java.util.Comparator;
import java.util.Map;

public class NameComparator implements Comparator<Map<String, Object>> {
	public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
		if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
			return -1;
		} else if (!((Boolean) hashA.get("is_dir"))
				&& ((Boolean) hashB.get("is_dir"))) {
			return 1;
		} else {
			return ((String) hashA.get("filename")).compareTo((String) hashB
					.get("filename"));
		}
	}
}
