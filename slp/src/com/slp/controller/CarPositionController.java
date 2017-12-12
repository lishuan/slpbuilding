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

@Controller("carposition")
@RequestMapping("/carposition/")
public class CarPositionController extends BaseController {
	// [start]车位信息管理
	//分页
		/*@RequestMapping(value = "searchlistuser", method = RequestMethod.POST)
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

		}*/
		
		//add  and  update
		@RequestMapping(value = "submitcarposition", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody String addcarposition(CarPositionEntity item,
				HttpServletRequest request) {
			ReturnResultEntity result = new ReturnResultEntity();
			if (ToolUtil.IsEmptyOrNull(item.getUnit())) {
				result.getFailureInfo("请选择所属单元楼");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getCarpositionsum()))) {
				result.getFailureInfo("请输入车位数量");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(item.getId())) {
				result = carpositionService.addCarPosition(item);
			} else {
				carpositionService.updateCarPosition(item);
			}
			return ReturnResult(result);
		}
		//单元下拉框change时间
		@RequestMapping(value = "getlistcarpositioncode")
		public @ResponseBody String  carpositioncodemodel(HttpServletRequest request) {
			String carpositionstatus=request.getParameter("carpositionstatus");
			SearchBaseEntity sbitem = new SearchBaseEntity();
			List<CarPositionEntity> result;
			String unit = request.getParameter("unit");
			if (ToolUtil.IsEmptyOrNull(unit)) {
				sbitem.setWhere("unit=''");
			} else {
				sbitem.setWhere("unit='" + unit + "'");
			}
			if("1".equals(carpositionstatus)){
				result = carpositionService.getListcarpositioncode1(sbitem);
			}else{
				 result = carpositionService.getListcarpositioncode(sbitem);
			}
			return gs.toJson(result);
		}
		/*//分配住房 取用户数据
		@RequestMapping(value = "getusername")
		public ModelAndView editUser(HttpServletRequest request) {
			String id = request.getParameter("userid");
			
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
			
		}*/
}
