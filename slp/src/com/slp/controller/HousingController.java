package com.slp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.slp.entity.HousingEntity;
import com.slp.entity.HousingMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.toolutil.ToolUtil;

@Controller("housing")
@RequestMapping("/housing/")
public class HousingController extends BaseController {
	
	// [start]楼宇信息管理
	//单元下拉框
	@RequestMapping(value = "getlisthousing")
	public ModelAndView  housingmodel(HttpServletRequest request) {
		String name=request.getParameter("name");
		SearchBaseEntity sbitem = new SearchBaseEntity();
		List<HousingEntity> result = housingService.getListhousing(sbitem);
		List<HousingEntity> unitlist = new ArrayList<HousingEntity>();
		for (HousingEntity a : result) {
			if (!ToolUtil.IsEmptyOrNull(String.valueOf(a.getUnit()))) {
				unitlist.add(a);
			}
		}
		request.setAttribute("unitlist", unitlist);
		if("homecode".equals(name)){
			return new ModelAndView("/user/housingmessage-add");
		}else{
			return new ModelAndView("/user/carposition-add");
		}
		
	}
	//单元下拉框change时间
		@RequestMapping(value = "getlisthousingfloors")
		public @ResponseBody String  housingfloorsmodel(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String unit = request.getParameter("unit");
			if (ToolUtil.IsEmptyOrNull(unit)) {
				sbitem.setWhere("unit=''");
			} else {
				sbitem.setWhere("unit='" + unit + "'");
			}
			List<HousingEntity> result = housingService.getListhousingfloors(sbitem);
			return gs.toJson(result);
		}
	//楼层下拉框change事件
		@RequestMapping(value = "getlisthousinghome")
		public @ResponseBody String  housinghomesmodel(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String unit = request.getParameter("unit");
			String floors=request.getParameter("floors");
			String homestatus=request.getParameter("homestatus");
			String where = "0=0";
			if (!ToolUtil.IsEmptyOrNull(unit)) {
				where += String.format(" and unit="+unit+"",unit);
			}
			else{
				where += String.format(" and unit=''");
			}
			if (!ToolUtil.IsEmptyOrNull(floors)) {
				where += String.format(" and floors="+floors+"",
						floors);
			}else{
				where += String.format(" and floors=''");
			}
			sbitem.setWhere(where);
			List<HousingMessageEntity> result;
			if("1".equals(homestatus)){
				
				 result = housingService.getListhousinghome1(sbitem);
			}else{
				 result = housingService.getListhousinghome(sbitem);
			}
			
			return gs.toJson(result);
		}
		//房间下拉框change事件
				@RequestMapping(value = "getlisthousinghometype")
				public @ResponseBody String  housinghometypesmodel(HttpServletRequest request) {
					SearchBaseEntity sbitem = new SearchBaseEntity();
					String unit = request.getParameter("unit");
					String floors=request.getParameter("floors");
					String homecode=request.getParameter("homecode");
					String where = "0=0";
					if (!ToolUtil.IsEmptyOrNull(unit)) {
						where += String.format(" and unit="+unit+"",unit);
					}
					else{
						where += String.format(" and unit=''");
					}
					if (!ToolUtil.IsEmptyOrNull(floors)) {
						where += String.format(" and floors="+floors+"",
								floors);
					}else{
						where += String.format(" and floors=''");
					}
					if (!ToolUtil.IsEmptyOrNull(homecode)) {
						where += String.format(" and homecode="+homecode+"",
								floors);
					}else{
						where += String.format(" and homecode=''");
					}
					sbitem.setWhere(where);
					
					List<HousingMessageEntity> result = housingService.getListhousinghometype(sbitem);
					return gs.toJson(result);
				}
	/*//分页
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
			result = userService.deluser(item);
			return ReturnResult(result);

		}*/
		
	//add  and  update
			@RequestMapping(value = "submithousing", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
			public @ResponseBody String addhousing(HousingEntity item,
					HttpServletRequest request) {
				ReturnResultEntity result = new ReturnResultEntity();
				if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getUnit()))) {
					result.getFailureInfo("请输入单元");
					return ReturnResult(result);
				}
				if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getFloors()))) {
					result.getFailureInfo("请输入总楼层数");
					return ReturnResult(result);
				}
				if (ToolUtil.IsEmptyOrNull(item.getId())) {
					result = housingService.addhousing(item);
					
				} else {
					housingService.updatehousing(item);
				}
				return ReturnResult(result);
			}
		/*//编辑 取单挑数据
		@RequestMapping(value = "edituser")
		public ModelAndView editUser(HttpServletRequest request) {
			String id = request.getParameter("userid");
			UserEntity item = userService.getOneUserModel(id);
			request.setAttribute("item", item);
			return new ModelAndView("/user/member-edit");
		}*/
}
