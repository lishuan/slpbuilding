package com.slp.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.slp.entity.ReturnResultEntity;

public class BaseController {

	// [start] 私有函数
	public String getIp(HttpServletRequest request) {
		String ipAddress = null;
		// ipAddress = this.getRequest().getRemoteAddr();
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}

		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	// [end]

	// [start] 公有变量
	public Gson gs = new Gson();
		@Autowired
		public com.slp.service.AdminService adminService;
		@Autowired
		public com.slp.service.UserService userService;
		@Autowired
		public com.slp.service.TenantsMessageService tenantsmessageService;
		@Autowired
		public com.slp.service.HousingService housingService;
		@Autowired
		public com.slp.service.HousingMessageService housingmessageService;
		@Autowired
		public com.slp.service.CarPositionService carpositionService;
		@Autowired
		public com.slp.service.CarPositionMessageService carpositionmessageService;
		@Autowired
		public com.slp.service.RegisterService registerService;
	// [end]

	// [start]公有函数
	public String ReturnResult(ReturnResultEntity result) {
		if (result.getResult()) {
			return gs.toJson(result.getMsg());
		}
		return gs.toJson(result.getMsg());

	}
	// [end]
}
