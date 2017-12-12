package com.slp.entity;


import com.slp.toolutil.DateUtil;

public class HousingMessageEntity {
	
	
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
	public String getHomecode() {
		return homecode;
	}
	public void setHomecode(String homecode) {
		this.homecode = homecode;
	}
	private String id;
	private int unit;//单元
	private int floors;//楼层数
	private String homecode;//房间编号或名称
	private int hometype;//房间类型
	public int getHometype() {
		return hometype;
	}
	public void setHometype(int hometype) {
		this.hometype = hometype;
	}
	private String addtime=DateUtil.GetDateTime();;
	private int status=0;//状态 
	private int homestatus=0;//状态 0开放 1建设中2关闭3拆迁...
	public int getHomestatus() {
		return homestatus;
	}
	public void setHomestatus(int homestatus) {
		this.homestatus = homestatus;
	}
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
