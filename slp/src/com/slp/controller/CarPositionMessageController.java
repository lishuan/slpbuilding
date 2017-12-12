package com.slp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.slp.entity.CarPositionMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.toolutil.DateUtil;
import com.slp.toolutil.ToolUtil;

@Controller("carpositionmessage")
@RequestMapping("/carpositionmessage/")
public class CarPositionMessageController extends BaseController {
	// [start]车位信息管理
	//分页
		@RequestMapping(value = "searchlistcarpositionmessage", method = RequestMethod.POST)
		public ModelAndView SearchListcarpositionmessage(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String where = "0=0";
			String username = request.getParameter("username");
			String unit = request.getParameter("unit");
			String carpositioncode = request.getParameter("carpositioncode");
			if (!ToolUtil.IsEmptyOrNull(username)) {
				where += String.format(" and (select username from user where userid=carpositionmessage.userid) like '%%%s%%'",
						username);
			}
			if (!ToolUtil.IsEmptyOrNull(unit)) {
				where += String.format(" and unit like '%%%s%%'",
						unit);
			}
			
			if (!ToolUtil.IsEmptyOrNull(carpositioncode)) {
				where += String.format(" and carpositioncode like '%%%s%%'",
						carpositioncode);
			}
			sbitem.setWhere(where);
			sbitem.setPage(DateUtil.GetInt(request.getParameter("page"), 1));
			sbitem.setPagesize(DateUtil.GetInt(request.getParameter("pagesize")));
			List<CarPositionMessageEntity> list = carpositionmessageService.getListCarPositionMessageRecordByPage(sbitem);
			request.setAttribute("list", list);
			return new ModelAndView("/user/searchcarpositionmessagelist");
		}
		//条件查询
		@RequestMapping(value = "searchlistcarpositionmessagecount", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody int SearchListcarpositionmessageCount(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String where = "0=0";
			String username = request.getParameter("username");
			String unit = request.getParameter("unit");
			String carpositioncode = request.getParameter("carpositioncode");
			if (!ToolUtil.IsEmptyOrNull(username)) {
				where += String.format(" and (select username from user where userid=carpositionmessage.userid) like '%%%s%%'",
						username);
			}
			if (!ToolUtil.IsEmptyOrNull(unit)) {
				where += String.format(" and unit like '%%%s%%'",
						unit);
			}
			
			if (!ToolUtil.IsEmptyOrNull(carpositioncode)) {
				where += String.format(" and carpositioncode like '%%%s%%'",
						carpositioncode);
			}
			sbitem.setWhere(where);
			int count = carpositionmessageService.getListCarPositionMessageRecordCount(sbitem);
			return count;
		}
		//删除
		/*@RequestMapping(value = "deluser", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
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
		@RequestMapping(value = "submitcarpositionmessage", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		public @ResponseBody String addcarposition(CarPositionMessageEntity item,
				HttpServletRequest request) {
			ReturnResultEntity result = new ReturnResultEntity();
			if (ToolUtil.IsEmptyOrNull(item.getUnit())) {
				result.getFailureInfo("请选择所属单元楼");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getCarpositioncode()))) {
				result.getFailureInfo("请选择车位代号");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getPositionprice()))) {
				result.getFailureInfo("请输入车位价格");
				return ReturnResult(result);
			}
			if (ToolUtil.IsEmptyOrNull(item.getId())) {
				result = carpositionmessageService.addCarPositionMessage(item);
			} else {
				carpositionmessageService.updateCarPositionMessage(item);
			}
			return ReturnResult(result);
		}
		/*//单元下拉框change时间
		@RequestMapping(value = "getlistcarpositioncode")
		public @ResponseBody String  carpositioncodemodel(HttpServletRequest request) {
			SearchBaseEntity sbitem = new SearchBaseEntity();
			String unit = request.getParameter("unit");
			if (ToolUtil.IsEmptyOrNull(unit)) {
				sbitem.setWhere("unit=''");
			} else {
				sbitem.setWhere("unit='" + unit + "'");
			}
			List<CarPositionEntity> result = carpositionService.getListcarpositioncode(sbitem);
			return gs.toJson(result);
		}*/
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
