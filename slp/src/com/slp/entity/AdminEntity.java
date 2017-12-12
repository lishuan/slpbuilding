package com.slp.entity;

import com.slp.toolutil.DateUtil;

/**
 * @Description:管理员实体
 * @Author: 李栓
 * @Version: V1.00
 * @Create Date: 2017年5月2日 下午2:52:27
 */
public class AdminEntity{



	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getLoginsum() {
		return loginsum;
	}
	public void setLoginsum(int loginsum) {
		this.loginsum = loginsum;
	}
	public String getIdcode() {
		return idcode;
	}
	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}
	public int getQxcode() {
		return qxcode;
	}
	public void setQxcode(int qxcode) {
		this.qxcode = qxcode;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String id;
	private String adminname;// 用户名
	private String password;// 密码
	private String realname;// 真实名称
	private int loginsum = 0;// 登陆次数
	private String idcode;//身份证
	private int qxcode=1;//权限代码，默认为1 高级权限
	private String logintime = DateUtil.GetDateTime();// 登陆时间
}
