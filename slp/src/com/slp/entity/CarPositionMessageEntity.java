package com.slp.entity;


import com.slp.toolutil.DateUtil;

public class CarPositionMessageEntity {
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
	private int positionprice;//车位价格
	public int getPositionprice() {
		return positionprice;
	}
	public void setPositionprice(int carpositionprice) {
		this.positionprice = carpositionprice;
	}
	public String getCarpositionid() {
		return carpositionid;
	}
	public void setCarpositionid(String carpositionid) {
		this.carpositionid = carpositionid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String carpositionid;//车位id
	private String userid;//用户id
	private int carpositioncode;//车位代码
	private int carpositionstatus;//车位状态
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
