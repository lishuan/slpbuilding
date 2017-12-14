package com.slp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.slp.entity.UserEntity;
import com.slp.entity.SqlCommandEntity;
import com.slp.toolutil.ToolUtil;
import com.slp.dao.RegisterDAO;
import com.slp.dao.UserDAO;
import com.slp.entity.RegisterEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;


/**
 * @Description:登记操作类
 * @Author: 李栓
 * @Version: V1.00
 * @Create Date: 2017年4月14日 下午5:29:21
 */

@Repository("RegisterDAO")
@Transactional
public class RegisterDAOImpl implements RegisterDAO {

	DbHelper db = new DbHelper();

	public RegisterDAOImpl() {
		if (null == db) {
			db = new DbHelper();
		}
	}

	@Override
	public ReturnResultEntity addregister(RegisterEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v = new ArrayList<Object>();
		sql = "insert into register(id,userid,unit,floors,homecode,remark,addtime,status) values(?,?,?,?,?,?,?,?)";
		if (ToolUtil.IsEmptyOrNull(item.getId())) {
			item.setId(ToolUtil.GetRandId());
		}
		v.add(item.getId());
		v.add(item.getUserid());
		v.add(item.getUnit());
		v.add(item.getFloors());
		v.add(item.getHomecode());
		v.add(item.getRemark());
		v.add(item.getAddtime());
		v.add(item.getStatus());
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}
	@Override
	public ReturnResultEntity updateregister(RegisterEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v = new ArrayList<Object>();
		sql = "update user set addtime=?,username=?,age=?,sex=?,tel=?,idcode=? where id=?";
		v.add(item.getAddtime());
		v.add(item.getUsername());
		v.add(item.getUserid());
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}

	@Override
	public ReturnResultEntity delregister(RegisterEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "update register set status=1 where id=?";
		List<Object> v = new ArrayList<Object>();
		v.add(String.valueOf(item.getId()));
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}
	@Override
	public RegisterEntity getOneregisterModel(String id) {
		RegisterEntity result = new RegisterEntity();
			String sql = "select * from user where userid=? and status=0";
			List<Object> value = new ArrayList<Object>();
			value.add(id);
			List<RegisterEntity> list = db.Query(new SqlCommandEntity(sql, value),
					RegisterEntity.class);
			if (list.size() == 0) {
				return new RegisterEntity();
			}
			result = list.get(0);
			return result;
		}
	@Override
	public List<RegisterEntity> getListregister(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RegisterEntity> getListregisterRecordByPage(SearchBaseEntity sbitem) {
		String sql = "select *,";
				sql+="(select username from user where userid=register.userid) as username,";
				sql+="(select tel from user where userid=register.userid) as tel";
				sql+= " from register where status=0";
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
		List<RegisterEntity> result = db.Query(new SqlCommandEntity(sql),
				RegisterEntity.class);
		return result;
	}

	

	@Override
	public int getListregisterRecordCount(SearchBaseEntity sbitem) {
		String sql = "select count(0) from register where status=0";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		int count = db.GetInt(new SqlCommandEntity(sql));
		return count;
	}
	
}
