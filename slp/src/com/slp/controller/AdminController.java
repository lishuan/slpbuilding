package com.slp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slp.entity.AdminEntity;
import com.slp.entity.ReturnResultEntity;


@Controller
@RequestMapping("/admin/")
public class AdminController extends BaseController {

	@RequestMapping(value = "submitadminlogin", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String submitAdminLogin(AdminEntity item,
			HttpServletRequest request) {
		ReturnResultEntity result = adminService.login(item);
		if (result.getResult()) {
			request.getSession(true).setAttribute("admin", result.getData());
		}
		return gs.toJson(result.getMsg());
	}
}
