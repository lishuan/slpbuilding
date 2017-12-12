package com.slp.entity;

public class SearchBaseEntity {

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public void setPage(int page) {
		this.start = page;
	}

	public int getStart() {
		int i = start - 1;
		i = i * pagesize;
		return i;
	}

	public int getEnd() {
		return pagesize;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	int pagesize;// 本页记录页
	int start = 1;// 开始记录序号
	String where = "";// 查询条件
	String orderby = "";// 排序条件
}
