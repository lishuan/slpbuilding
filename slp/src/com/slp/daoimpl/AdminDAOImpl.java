package com.slp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.slp.entity.LogEntity;
import com.slp.entity.SqlCommandEntity;
import com.slp.toolutil.ToolUtil;
import com.slp.dao.AdminDAO;

import com.slp.entity.AdminEntity;

import com.slp.entity.ReturnResultEntity;


/**
 * @Description:会员操作类
 * @Author: 老史
 * @Version: V1.00
 * @Create Date: 2017年4月14日 下午5:29:21
 */

@Repository("AdminDAO")
@Transactional
public class AdminDAOImpl implements AdminDAO {

	DbHelper db = new DbHelper();

	public AdminDAOImpl() {
		if (null == db) {
			db = new DbHelper();
		}
	}

	@Override
	public ReturnResultEntity login(AdminEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "select * from admin where adminname=? limit 0,1";
		List<Object> v = new ArrayList<Object>();
		v.add(item.getAdminname());
		List<AdminEntity> list = db.Query(new SqlCommandEntity(sql, v),
				AdminEntity.class);
		if (list.size() == 0) {
			result.getFailureInfo("用户名错误");
			return result;
		}
		AdminEntity newitem = list.get(0);
		item.setPassword(ToolUtil.GetMD5Code(item.getPassword()));
		if (newitem.getPassword().equals(item.getPassword()) == false) {
			result.getFailureInfo("密码错误");
			return result;
		}
		List<SqlCommandEntity> listcmd = new ArrayList<SqlCommandEntity>();
		sql = "update admin set logintime=now(),loginsum=loginsum+1 where id=?";
		v = new ArrayList<Object>();
		v.add(newitem.getId());
		System.out.println(newitem.getId());
		listcmd.add(new SqlCommandEntity(sql, v));
		//添加日志
		LogEntity log = new LogEntity();
		log.setId(newitem.getId());
		log.setAdminname(item.getAdminname());
		log.setRemark("管理员登录");
		listcmd.add(db.AddAdminLog(log));
		
		result = db.Execute(listcmd);
		if (result.getResult()) {
			result.getSuccessInfo(newitem);
		}

		return result;
	}
	
}
