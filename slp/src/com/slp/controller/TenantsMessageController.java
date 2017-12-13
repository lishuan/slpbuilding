package com.slp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.slp.entity.UserEntity;
import com.slp.entity.HousingMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.entity.TenantsMessageEntity;
import com.slp.toolutil.DateUtil;
import com.slp.toolutil.ToolUtil;

@Controller("tenantsmessage")
@RequestMapping("/tenantsmessage/")
public class TenantsMessageController extends BaseController {
	// [start]租客信息管理
	//分页
		@RequestMapping(value = "searchlisttenantsmessage", method = RequestMethod.POST)
		public ModelAndView SearchListTenantsMessage(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String where = "0=0";
			String username = request.getParameter("username");
			String idcode = request.getParameter("idcode");
			String addtime = request.getParameter("addtime");
			String unit = request.getParameter("unit");
			String homecode = request.getParameter("homecode");
			String floors = request.getParameter("floors");
			String tel = request.getParameter("tel");
			if (!ToolUtil.IsEmptyOrNull(unit)) {
				where += String.format(" and unit like '%%%s%%'",
						unit);
			}
			if (!ToolUtil.IsEmptyOrNull(homecode)) {
				where += String.format(" and homecode like '%%%s%%'",
						homecode);
			}
			if (!ToolUtil.IsEmptyOrNull(floors)) {
				where += String.format(" and floors like '%%%s%%'",
						floors);
			}
			if (!ToolUtil.IsEmptyOrNull(tel)) {
				where += String.format(" and (select tel from user where userid=tenantsmessage.userid) like '%%%s%%'",
						tel);
			}
			if (!ToolUtil.IsEmptyOrNull(username)) {
				where += String.format(" and (select username from user where userid=tenantsmessage.userid)  like '%%%s%%'",
						username);
			}
			if (!ToolUtil.IsEmptyOrNull(idcode)) {
				where += String.format(" and (select idcode from user where userid=tenantsmessage.userid)  like '%%%s%%'",
						idcode);
			}
			
			if (!ToolUtil.IsEmptyOrNull(addtime)) {
				where += String.format(" and addtime like '%%%s%%'",
						addtime);
			}
			sbitem.setWhere(where);
			sbitem.setPage(DateUtil.GetInt(request.getParameter("page"), 1));
			sbitem.setPagesize(DateUtil.GetInt(request.getParameter("pagesize")));
			List<TenantsMessageEntity> list = tenantsmessageService.getListTenantsMessageRecordByPage(sbitem);
			request.setAttribute("list", list);
			return new ModelAndView("/user/searchtenantsmessagelist");
		}
		//条件查询
		@RequestMapping(value = "searchlisttenantsmessagecount", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody int SearchListTenantsMessageCount(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String where = "0=0";
			String username = request.getParameter("username");
			String idcode = request.getParameter("idcode");
			String addtime = request.getParameter("addtime");
			String unit = request.getParameter("unit");
			String homecode = request.getParameter("homecode");
			String floors = request.getParameter("floors");
			String tel = request.getParameter("tel");
			if (!ToolUtil.IsEmptyOrNull(unit)) {
				where += String.format(" and unit like '%%%s%%'",
						unit);
			}
			if (!ToolUtil.IsEmptyOrNull(homecode)) {
				where += String.format(" and homecode like '%%%s%%'",
						homecode);
			}
			if (!ToolUtil.IsEmptyOrNull(floors)) {
				where += String.format(" and floors like '%%%s%%'",
						floors);
			}
			if (!ToolUtil.IsEmptyOrNull(tel)) {
				where += String.format(" and (select tel from user where userid=tenantsmessage.userid)  like '%%%s%%'",
						tel);
			}
			if (!ToolUtil.IsEmptyOrNull(username)) {
				where += String.format(" and (select username from user where userid=tenantsmessage.userid)  like '%%%s%%'",
						username);
			}
			if (!ToolUtil.IsEmptyOrNull(idcode)) {
				where += String.format(" and (select idcode from user where userid=tenantsmessage.userid)  like '%%%s%%'",
						idcode);
			}
			
			if (!ToolUtil.IsEmptyOrNull(addtime)) {
				where += String.format(" and addtime like '%%%s%%'",
						addtime);
			}
			sbitem.setWhere(where);
			int count = tenantsmessageService.getListTenantsMessageRecordCount(sbitem);
			return count;
		}
		//删除
		@RequestMapping(value = "deltenantsmessage", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody String DelTenantsMessage(TenantsMessageEntity item,
				HttpServletRequest request) {
			ReturnResultEntity result = new ReturnResultEntity();
			result = tenantsmessageService.delTenantsMessage(item);
			return ReturnResult(result);

		}
		
		//add  and  update
		@RequestMapping(value = "submittenantsmessage", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody String adduser(TenantsMessageEntity item,
				HttpServletRequest request) {
			ReturnResultEntity result = new ReturnResultEntity();
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getUnit()))) {
				result.getFailureInfo("请选择单元");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getFloors()))) {
				result.getFailureInfo("请选择楼层");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getHomecode()))) {
				result.getFailureInfo("请选择房间");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getHomerent()))) {
				result.getFailureInfo("请输入房租");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getHometype()))) {
				result.getFailureInfo("请选择房间类型");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(item.getId())) {
				result = tenantsmessageService.addTenantsMessage(item);
			} else {
				tenantsmessageService.updateTenantsMessage(item);
			}
			return ReturnResult(result);
		}
		//编辑 取单挑数据
		@RequestMapping(value = "edittenantsmessage")
		public ModelAndView editUser(HttpServletRequest request) {
			String id = request.getParameter("userid");
			UserEntity item = userService.getOneUserModel(id);
			request.setAttribute("item", item);
			return new ModelAndView("/user/member-edit");
		}
		
		//房间下拉框change事件
		@RequestMapping(value = "getlisttenantsmessageuserid")
		public @ResponseBody String  housinghometypesmodel(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String unit = request.getParameter("unit");
			String floors=request.getParameter("floors");
			String homecode=request.getParameter("homecode");
			String where = "0=0";
			if (!ToolUtil.IsEmptyOrNull(unit)) {
				where += String.format(" and unit="+unit+"",unit);
			}
			if (!ToolUtil.IsEmptyOrNull(floors)) {
				where += String.format(" and floors="+floors+"",
						floors);
			}
			if (!ToolUtil.IsEmptyOrNull(homecode)) {
				where += String.format(" and homecode="+homecode+"",
						floors);
			}
			sbitem.setWhere(where);
			List<TenantsMessageEntity> result = tenantsmessageService.getlisttenantsmessageuserid(sbitem);
			return gs.toJson(result);
		}
}
