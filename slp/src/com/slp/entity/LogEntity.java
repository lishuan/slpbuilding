package com.slp.entity;

/**
 * @Description:操作日志实体
 * @Author: 李栓
 * @Version: V1.00
 * @Create Date: 2017年3月18日 下午2:10:48
 */
public class LogEntity {

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getId() {
		return id;
	}

	public void setId(String rowid) {
		this.id = rowid;
	}
	private String id;// ID
	private String addtime;// 当前时间
	private int status = 0;// 记录状态0正常1删除
	private String adminname;// 操作人姓名
	private String remark="";// 操作简介
	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
}
