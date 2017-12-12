package com.slp.entity;

import com.slp.toolutil.DateUtil;

public class ReturnResultEntity {

	public boolean getResult() {
		return result;
	}

	public String getMsg() {
		return DateUtil.GetString(msg);
	}

	public Object getData() {
		return data;
	}

	public ReturnResultEntity getSuccessInfo(Object obj) {
		result = true;
		data = obj;
		return this;
	}

	public ReturnResultEntity getSuccessInfo() {
		result = true;
		return this;
	}

	public ReturnResultEntity getFailureInfo(String message) {
		result = false;
		msg = DateUtil.GetString(message);
		data = null;
		return this;
	}

	boolean result = false;// 运行结果
	String msg = "";// 提示信息
	Object data = new Object();// 返回结果
}
