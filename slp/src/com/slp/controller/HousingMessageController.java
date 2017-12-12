package com.slp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.slp.entity.HousingMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.toolutil.ToolUtil;

@Controller("housingmessage")
@RequestMapping("/housingmessage/")
public class HousingMessageController extends BaseController {
	
	/*@RequestMapping(value = "getlisthousingmessage")
	public ModelAndView productcarmodel(HttpServletRequest request) {
		SearchBaseEntity sbitem = new SearchBaseEntity();
		String productid = request.getParameter("unit");
		sbitem.setWhere(String
				.format("id not in (select carmodelid from productcarmodel where productid='%s')",
						productid));
		List<HousingMessageEntity> listunit = housingmessageService.getListhousingmessage(sbitem);
		request.setAttribute("listunit", listunit);
		sbitem.setWhere("");
		List<HousingMessageEntity> listfloors = housingmessageService.getListhousingmessage(sbitem);
		request.setAttribute("listfloors", listfloors);
		return new ModelAndView("/admin/housingmessage-add");
	}*/
	// [start]楼宇信息管理
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
			@RequestMapping(value = "submithousingmessage", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
			public @ResponseBody String addhousing(HousingMessageEntity item,
					HttpServletRequest request) {
				ReturnResultEntity result = new ReturnResultEntity();
				if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getUnit()))) {
					result.getFailureInfo("请选择所属单元");
					return ReturnResult(result);
				}
				if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getFloors()))) {
					result.getFailureInfo("请选择楼层数");
					return ReturnResult(result);
				}
				if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getHometype()))) {
					result.getFailureInfo("请选择房间类型");
					return ReturnResult(result);
				}
				if (ToolUtil.IsEmptyOrNull(String.valueOf(item.getHomecode()))) {
					result.getFailureInfo("请输入房间名称");
					return ReturnResult(result);
				}
				if (ToolUtil.IsEmptyOrNull(item.getId())) {
					result = housingmessageService.addhousingmessage(item);
					
				} else {
					housingmessageService.updatehousingmessage(item);
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
