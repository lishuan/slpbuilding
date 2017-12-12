package com.slp.entity;


import com.slp.toolutil.DateUtil;

public class HousingEntity {
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getFloors() {
		return floors;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	private String id;
	private int unit;//单元
	private int floors;//楼层数
	private String addtime=DateUtil.GetDateTime();;
	private int status=0;
	private int homestatus=0;//房间状态0：空闲 中1：租用中
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	/*
	public int i=1; //默认楼层为1，后面会根据输入的数去循环插入
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}*/
}
