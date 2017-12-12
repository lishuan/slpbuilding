package com.slp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.slp.entity.SqlCommandEntity;
import com.slp.entity.TenantsMessageEntity;
import com.slp.toolutil.ToolUtil;
import com.slp.dao.TenantsMessageDAO;

import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;


/**
 * @Description:会员操作类
 * @Author: 
 * @Version: V1.00
 * @Create Date: 2017年4月14日 下午5:29:21
 */

@Repository("TenantsMessageDAO")
@Transactional
public class TenantsMessageDAOImpl implements TenantsMessageDAO {

	DbHelper db = new DbHelper();

	public TenantsMessageDAOImpl() {
		if (null == db) {
			db = new DbHelper();
		}
	}
	@Override
	public ReturnResultEntity addTenantsMessage(TenantsMessageEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v = new ArrayList<Object>();
		sql = "insert into tenantsmessage(id,unit,floors,homecode,hometype,homerent,status,addtime,userid,housingmessageid) values(?,?,?,?,?,?,?,?,?,?)";
		if (ToolUtil.IsEmptyOrNull(item.getId())) {
			item.setId(ToolUtil.GetRandId());
		}
		v.add(item.getId());
		v.add(item.getUnit());
		v.add(item.getFloors());
		v.add(item.getHomecode());
		v.add(item.getHometype());
		v.add(item.getHomerent());
		v.add(item.getStatus());
		v.add(item.getAddtime());
		v.add(item.getUserid());
		v.add(item.getHousingmessageid());
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		//修改房间状态
		v = new ArrayList<Object>();
		sql="update housingmessage set homestatus=1 where unit=? and floors=? and homecode=?";
		v.add(item.getUnit());
		v.add(item.getFloors());
		v.add(item.getHomecode());
		List<SqlCommandEntity> list1 = new ArrayList<SqlCommandEntity>();
		list1.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list1);
		return result;
	}

	@Override
	public ReturnResultEntity updateTenantsMessage(TenantsMessageEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v = new ArrayList<Object>();
		sql = "update user set addtime=?,username=?,age=?,sex=?,tel=?,idcode=? where id=?";
		v.add(item.getAddtime());
		
		v.add(item.getUserid());
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}

	@Override
	public ReturnResultEntity delTenantsMessage(TenantsMessageEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "update housingmessage set homestatus=0 where id=?";
		List<Object> v = new ArrayList<Object>();
		v.add(String.valueOf(item.getHousingmessageid()));
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}

	@Override
	public TenantsMessageEntity getOneTenantsMessageModel(String id) {
		TenantsMessageEntity result = new TenantsMessageEntity();
		String sql = "select * from user where userid=? and status=0";
		List<Object> value = new ArrayList<Object>();
		value.add(id);
		List<TenantsMessageEntity> list = db.Query(new SqlCommandEntity(sql, value),
				TenantsMessageEntity.class);
		if (list.size() == 0) {
			return new TenantsMessageEntity();
		}
		result = list.get(0);
		return result;
	}

	@Override
	public List<TenantsMessageEntity> getListTenantsMessageRecordByPage(SearchBaseEntity sbitem) {
		String sql = "SELECT *,";
				sql+="(SELECT username FROM USER WHERE userid=tenantsmessage.userid) AS username,";
				sql+="(SELECT tel FROM USER WHERE userid=tenantsmessage.userid)AS tel,";
				sql+="(SELECT idcode FROM USER WHERE userid=tenantsmessage.userid)AS idcode,";
				sql+="(select homestatus from housingmessage where id=tenantsmessage.housingmessageid)AS homestatus";
				sql+=" FROM  tenantsmessage WHERE housingmessageid=(SELECT id FROM housingmessage WHERE homestatus=1 AND id=tenantsmessage.housingmessageid)";
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
		List<TenantsMessageEntity> result = db.Query(new SqlCommandEntity(sql),
				TenantsMessageEntity.class);
		return result;
	}

	@Override
	public List<TenantsMessageEntity> getListTenantsMessage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListTenantsMessageRecordCount(SearchBaseEntity sbitem) {
		String sql = "select count(0) from tenantsmessage where housingmessageid=(SELECT id FROM housingmessage WHERE homestatus=1 AND id=tenantsmessage.housingmessageid)";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		int count = db.GetInt(new SqlCommandEntity(sql));
		return count;
	}
	
}
