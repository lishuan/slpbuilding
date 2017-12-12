package com.slp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.slp.entity.UserEntity;
import com.slp.entity.CarPositionEntity;
import com.slp.entity.HousingEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.toolutil.DateUtil;
import com.slp.toolutil.ToolUtil;

@Controller("user")
@RequestMapping("/user/")
public class UserController extends BaseController {
	// [start]用户信息管理
	//分页
		@RequestMapping(value = "searchlistuser", method = RequestMethod.POST)
		public ModelAndView SearchListNews(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String where = "0=0";
			String username = request.getParameter("username");
			String idcode = request.getParameter("idcode");
			String addtime = request.getParameter("addtime");
			if (!ToolUtil.IsEmptyOrNull(username)) {
				where += String.format(" and username like '%%%s%%'",
						username);
			}
			if (!ToolUtil.IsEmptyOrNull(idcode)) {
				where += String.format(" and idcode like '%%%s%%'",
						idcode);
			}
			
			if (!ToolUtil.IsEmptyOrNull(addtime)) {
				where += String.format(" and addtime like '%%%s%%'",
						addtime);
			}
			sbitem.setWhere(where);
			sbitem.setPage(DateUtil.GetInt(request.getParameter("page"), 1));
			sbitem.setPagesize(DateUtil.GetInt(request.getParameter("pagesize")));
			List<UserEntity> list = userService.getListUserRecordByPage(sbitem);
			request.setAttribute("list", list);
			return new ModelAndView("/user/searchuserlist");
		}
		//条件查询
		@RequestMapping(value = "searchlistusercount", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody int SearchListUserCount(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String where = "0=0";
			String username = request.getParameter("username");
			String idcode = request.getParameter("idcode");
			String addtime = request.getParameter("addtime");
			if (!ToolUtil.IsEmptyOrNull(username)) {
				where += String.format(" and username like '%%%s%%'",
						username);
			}
			if (!ToolUtil.IsEmptyOrNull(idcode)) {
				where += String.format(" and idcode like '%%%s%%'",
						idcode);
			}
			
			if (!ToolUtil.IsEmptyOrNull(addtime)) {
				where += String.format(" and addtime like '%%%s%%'",
						addtime);
			}
			sbitem.setWhere(where);
			int count = userService.getListUserRecordCount(sbitem);
			return count;
		}
		//删除
		@RequestMapping(value = "deluser", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody String DelUser(UserEntity item,
				HttpServletRequest request) {
			ReturnResultEntity result = new ReturnResultEntity();
			String id=request.getParameter("userid");
			String[] strarr = id.split(",");
			if(strarr.length>0){
				for(int i=0;i<strarr.length;i++){
					String idone=strarr[i];
					item.setUserid(idone);
					result = userService.deluser(item);
				}
			}	
			return ReturnResult(result);

		}
		
		//add  and  update
		@RequestMapping(value = "submituser", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody String adduser(UserEntity item,
				HttpServletRequest request) {
			ReturnResultEntity result = new ReturnResultEntity();
			if (ToolUtil.IsEmptyOrNull(item.getUsername())) {
				result.getFailureInfo("请输入用户名");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(item.getIdcode())) {
				result.getFailureInfo("请输入身份证");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getTel()))) {
				result.getFailureInfo("请输入手机号");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(item.getUserid())) {
				result = userService.adduser(item);
			} else {
				userService.updateuser(item);
			}
			return ReturnResult(result);
		}
		//分配住房和车位 取用户数据
		@RequestMapping(value = "getusername")
		public ModelAndView editUser(HttpServletRequest request) {
			String id = request.getParameter("userid");
			String carposition=request.getParameter("carposition");
			String carpositionmessage=request.getParameter("carpositionmessage");
			if("carposition".equals(carposition)){
				
				UserEntity item = userService.getOneUserModel(id);
				request.setAttribute("item", item);
				//取车位信息用以分配
				SearchBaseEntity sbitem = new SearchBaseEntity();
				List<CarPositionEntity> result = carpositionService.getListCarPosition(sbitem);
				List<CarPositionEntity> unitlist = new ArrayList<CarPositionEntity>();
				for (CarPositionEntity a : result) {
					if (!ToolUtil.IsEmptyOrNull(String.valueOf(a.getUnit()))) {
						unitlist.add(a);
					}
				}
				request.setAttribute("unitlist", unitlist);
				if("carpositionmessage".equals(carpositionmessage)){
					//车位信息
					return new ModelAndView("/user/carpositionmessage-list");
				}else{
					return new ModelAndView("/user/user-add-carpositionmessage");
				}
				
			}else{
				//取房间信息用以分配
				SearchBaseEntity sbitem = new SearchBaseEntity();
				List<HousingEntity> result = housingService.getListhousing(sbitem);
				List<HousingEntity> unitlist = new ArrayList<HousingEntity>();
				for (HousingEntity a : result) {
					if (!ToolUtil.IsEmptyOrNull(String.valueOf(a.getUnit()))) {
						unitlist.add(a);
					}
				}
				request.setAttribute("unitlist", unitlist);
				//id不为空根据用户id分配住房，否则返回租客信息列表
				if(id!=null){
					UserEntity item = userService.getOneUserModel(id);
					request.setAttribute("item", item);
					return new ModelAndView("/user/user-add-housingmessage");
				}else{
					return new ModelAndView("/user/tenantsmessage-list");
				}
			}
		
			
			
		}
}
