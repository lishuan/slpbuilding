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
import com.slp.entity.RegisterEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.toolutil.DateUtil;
import com.slp.toolutil.ToolUtil;

@Controller("register")
@RequestMapping("/register/")
public class RegisterController extends BaseController {
	// [start]用户信息管理
	//分页
		@RequestMapping(value = "searchlistregister", method = RequestMethod.POST)
		public ModelAndView SearchListNews(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String where = "0=0";
			String unit = request.getParameter("unit");
			String floors = request.getParameter("floors");
			String homecode = request.getParameter("homecode");
			if (!ToolUtil.IsEmptyOrNull(unit)) {
				where += String.format(" and unit like '%%%s%%'",
						unit);
			}
			if (!ToolUtil.IsEmptyOrNull(floors)) {
				where += String.format(" and floors like '%%%s%%'",
						floors);
			}
			
			if (!ToolUtil.IsEmptyOrNull(homecode)) {
				where += String.format(" and homecode like '%%%s%%'",
						homecode);
			}
			sbitem.setWhere(where);
			sbitem.setPage(DateUtil.GetInt(request.getParameter("page"), 1));
			sbitem.setPagesize(DateUtil.GetInt(request.getParameter("pagesize")));
			List<RegisterEntity> list = registerService.getListregisterRecordByPage(sbitem);
			request.setAttribute("list", list);
			return new ModelAndView("/user/searchregisterlist");
		}
		//条件查询
		@RequestMapping(value = "searchlistregistercount", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody int SearchListUserCount(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String where = "0=0";
			String unit = request.getParameter("unit");
			String floors = request.getParameter("floors");
			String homecode = request.getParameter("homecode");
			if (!ToolUtil.IsEmptyOrNull(unit)) {
				where += String.format(" and unit like '%%%s%%'",
						unit);
			}
			if (!ToolUtil.IsEmptyOrNull(floors)) {
				where += String.format(" and floors like '%%%s%%'",
						floors);
			}
			
			if (!ToolUtil.IsEmptyOrNull(homecode)) {
				where += String.format(" and homecode like '%%%s%%'",
						homecode);
			}
			sbitem.setWhere(where);
			int count = registerService.getListregisterRecordCount(sbitem);
			return count;
		}
		//删除
		@RequestMapping(value = "delregister", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody String DelUser(RegisterEntity item,
				HttpServletRequest request) {
			ReturnResultEntity result = new ReturnResultEntity();
			String id=request.getParameter("id");
			String[] strarr = id.split(",");
			if(strarr.length>0){
				for(int i=0;i<strarr.length;i++){
					String idone=strarr[i];
					item.setId(idone);
					result = registerService.delregister(item);
				}
			}	
			return ReturnResult(result);

		}
		
		//add  and  update
		@RequestMapping(value = "submitregister", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody String adduser(RegisterEntity item,
				HttpServletRequest request) {
			ReturnResultEntity result = new ReturnResultEntity();
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getUnit()))) {
				result.getFailureInfo("请选择所属单元");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getFloors()))) {
				result.getFailureInfo("请选择所属楼层");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getHomecode()))) {
				result.getFailureInfo("请选择所属房间");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(item.getRemark())) {
				result.getFailureInfo("请输入登记内容");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(item.getId())) {
				result = registerService.addregister(item);
			} else {
				registerService.updateregister(item);
			}
			return ReturnResult(result);
		}
		//取单元信息
		@RequestMapping(value = "gethousing")
		public ModelAndView gethousing(HttpServletRequest request) {
			String welcome=request.getParameter("welcome");
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
			if("welcome".equals(welcome)){
				return new ModelAndView("/user/welcome");
			}else{
				return new ModelAndView("/user/user-add-register");
			}
		}
}
