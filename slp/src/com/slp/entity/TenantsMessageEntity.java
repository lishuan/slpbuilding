package com.slp.entity;


import com.slp.toolutil.DateUtil;


public class TenantsMessageEntity {
	private String userid;//对应用户表
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getHomestatus() {
		return homestatus;
	}
	public void setHomestatus(int homestatus) {
		this.homestatus = homestatus;
	}
	public int getHomerent() {
		return homerent;
	}
	public void setHomerent(int homerent) {
		this.homerent = homerent;
	}
	
	public String getHomecode() {
		return homecode;
	}
	public void setHomecode(String homecode) {
		this.homecode = homecode;
	}
	public int getHometype() {
		return hometype;
	}
	public void setHometype(int hometype) {
		this.hometype = hometype;
	}
	private String id;
	private int unit;//单元
	private int floors;//楼层
	private String homecode;// 房间号
	private int hometype;//房间类型0：单间1：小套2：大套
	private String addtime=DateUtil.GetDateTime();//入住时间
	private int status=0;//状态 1为删除
	private int homestatus;//房间状态1：租用中0：空闲 中
	private int homerent; //房租 
	private String housingmessageid;//关联房间信息
	
	public String getHousingmessageid() {
		return housingmessageid;
	}
	public void setHousingmessageid(String housingmessageid) {
		this.housingmessageid = housingmessageid;
	}
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getIdcode() {
		return idcode;
	}
	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}
	private int tel;// 
	private String idcode;//
}
