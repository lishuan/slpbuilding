package com.slp.entity;

import java.util.List;

public class SqlCommandEntity {

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<Object> getParams() {
		return params;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}

	private String sql = "";// 运行sql
	private List<Object> params = null;// 参数

	public SqlCommandEntity(String sql, List<Object> params) {
		this.sql = sql;
		this.params = params;
	}

	public SqlCommandEntity(String sql) {
		this.sql = sql;
		this.params = null;
	}
}
