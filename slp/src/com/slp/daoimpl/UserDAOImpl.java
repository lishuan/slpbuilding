package com.slp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.slp.entity.UserEntity;
import com.slp.entity.SqlCommandEntity;
import com.slp.toolutil.ToolUtil;
import com.slp.dao.UserDAO;

import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;


/**
 * @Description:会员操作类
 * @Author: 老史
 * @Version: V1.00
 * @Create Date: 2017年4月14日 下午5:29:21
 */

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	DbHelper db = new DbHelper();

	public UserDAOImpl() {
		if (null == db) {
			db = new DbHelper();
		}
	}

	@Override
	public ReturnResultEntity adduser(UserEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v = new ArrayList<Object>();
		sql = "insert into user(userid,username,age,sex,tel,idcode,addtime,status) values(?,?,?,?,?,?,?,?)";
		if (ToolUtil.IsEmptyOrNull(item.getUserid())) {
			item.setUserid(ToolUtil.GetRandId());
		}
		v.add(item.getUserid());
		v.add(item.getUsername());
		v.add(item.getAge());
		v.add(item.getSex());
		v.add(item.getTel());
		v.add(item.getIdcode());
		v.add(item.getAddtime());
		v.add(item.getStatus());
		
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}
	@Override
	public ReturnResultEntity updateuser(UserEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v = new ArrayList<Object>();
		sql = "update user set addtime=?,username=?,age=?,sex=?,tel=?,idcode=? where id=?";
		v.add(item.getAddtime());
		v.add(item.getUsername());
		v.add(item.getAge());
		v.add(item.getSex());
		v.add(item.getTel());
		v.add(item.getIdcode());
		v.add(item.getUserid());
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}

	@Override
	public ReturnResultEntity deluser(UserEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "update user set status=1 where userid=?";
		List<Object> v = new ArrayList<Object>();
		v.add(String.valueOf(item.getUserid()));
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}
	@Override
	public UserEntity getOneUserModel(String id) {
		UserEntity result = new UserEntity();
			String sql = "select * from user where userid=? and status=0";
			List<Object> value = new ArrayList<Object>();
			value.add(id);
			List<UserEntity> list = db.Query(new SqlCommandEntity(sql, value),
					UserEntity.class);
			if (list.size() == 0) {
				return new UserEntity();
			}
			result = list.get(0);
			return result;
		}
	@Override
	public List<UserEntity> getListUser(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserEntity> getListUserRecordByPage(SearchBaseEntity sbitem) {
		String sql = "select * from user where status=0";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		if (!ToolUtil.IsEmptyOrNull(sbitem.getOrderby())) {
			sql += " order by " + sbitem.getOrderby();
		} else {
			sql += " order by addtime desc";
		}
		sql += String
				.format(" limit %d,%d", sbitem.getStart(), sbitem.getEnd());
		List<UserEntity> result = db.Query(new SqlCommandEntity(sql),
				UserEntity.class);
		return result;
	}

	

	@Override
	public int getListUserRecordCount(SearchBaseEntity sbitem) {
		String sql = "select count(0) from user where status=0";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		int count = db.GetInt(new SqlCommandEntity(sql));
		return count;
	}
	
}
