package com.slp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.slp.entity.SqlCommandEntity;
import com.slp.toolutil.ToolUtil;
import com.slp.dao.HousingMessageDAO;
import com.slp.entity.HousingEntity;
import com.slp.entity.HousingMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;


/**
 * @Description:房间操作类
 * @Author: 老史
 * @Version: V1.00
 * @Create Date: 2017年4月14日 下午5:29:21
 */

@Repository("HousingMessageDAO")
@Transactional
public class HousingMessageDAOImpl implements HousingMessageDAO {

	DbHelper db = new DbHelper();

	public HousingMessageDAOImpl() {
		if (null == db) {
			db = new DbHelper();
		}
	}

	@Override
	public ReturnResultEntity addhousingmessage(HousingMessageEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v;
		sql = "select count(0) from housingmessage where homecode=? and unit=? and floors=? and status=0";
		v = new ArrayList<Object>();
		v.add(item.getHomecode());
		v.add(item.getUnit());
		v.add(item.getFloors());
		int count = db.GetInt(new SqlCommandEntity(sql, v));
		if (count > 0) {
			result.getFailureInfo(item.getUnit()+"单元"+item.getFloors()+"楼"+item.getHomecode() + "房间已存在！");
			return result;
		}
		v = new ArrayList<Object>();
		sql = "insert into housingmessage(id,unit,floors,homecode,hometype,homestatus,status,addtime) values(?,?,?,?,?,?,?,?)";
		if (ToolUtil.IsEmptyOrNull(item.getId())) {
			item.setId(ToolUtil.GetRandId());
		}
		v.add(item.getId());
		v.add(item.getUnit());
		v.add(item.getFloors());
		v.add(item.getHomecode());
		v.add(item.getHometype());
		v.add(item.getHomestatus());
		v.add(item.getStatus());
		v.add(item.getAddtime());
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
		}
	@Override
	public ReturnResultEntity updatehousingmessage(HousingMessageEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v = new ArrayList<Object>();
		sql = "update user set addtime=?,username=?,age=?,sex=?,tel=?,idcode=? where id=?";
		v.add(item.getAddtime());
	
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}

	@Override
	public ReturnResultEntity delhousingmessage(HousingMessageEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "update user set status=1 where userid=?";
		List<Object> v = new ArrayList<Object>();
		v.add(String.valueOf(item.getId()));
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}
	@Override
	public HousingMessageEntity getOnehousingmessageModel(String id) {
		HousingMessageEntity result = new HousingMessageEntity();
			String sql = "select * from user where userid=? and status=0";
			List<Object> value = new ArrayList<Object>();
			value.add(id);
			List<HousingMessageEntity> list = db.Query(new SqlCommandEntity(sql, value),
					HousingMessageEntity.class);
			if (list.size() == 0) {
				return new HousingMessageEntity();
			}
			result = list.get(0);
			return result;
		}
	@Override
	public List<HousingMessageEntity> getListhousingmessage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<HousingMessageEntity> getListhousingmessageRecordByPage(SearchBaseEntity sbitem) {
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
		List<HousingMessageEntity> result = db.Query(new SqlCommandEntity(sql),
				HousingMessageEntity.class);
		return result;
	}

	

	@Override
	public int getListhousingmessageRecordCount(SearchBaseEntity sbitem) {
		String sql = "select count(0) from user where status=0";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		int count = db.GetInt(new SqlCommandEntity(sql));
		return count;
	}
}
