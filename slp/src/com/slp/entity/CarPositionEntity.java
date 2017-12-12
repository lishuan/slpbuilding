package com.slp.entity;


import com.slp.toolutil.DateUtil;

public class CarPositionEntity {
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	private String id;
	private String unit;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	private String addtime=DateUtil.GetDateTime();;
	private int status=0;//状态 1为删除
	private int carpositionsum=0;//车位数量
	private int carpositionstatus=0;//车位状态 0:空闲1：被租用
	private int carpositioncode;//车位代码
	public int getCarpositionstatus() {
		return carpositionstatus;
	}
	public void setCarpositionstatus(int carpositionstatus) {
		this.carpositionstatus = carpositionstatus;
	}
	public int getCarpositioncode() {
		return carpositioncode;
	}
	public void setCarpositioncode(int carpositioncode) {
		this.carpositioncode = carpositioncode;
	}
	public int getCarpositionsum() {
		return carpositionsum;
	}
	public void setCarpositionsum(int carpositionsum) {
		this.carpositionsum = carpositionsum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
