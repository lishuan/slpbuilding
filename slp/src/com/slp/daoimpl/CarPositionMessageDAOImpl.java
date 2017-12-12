package com.slp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.slp.entity.SqlCommandEntity;
import com.slp.toolutil.ToolUtil;
import com.slp.dao.CarPositionMessageDAO;
import com.slp.entity.CarPositionMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;


/**
 * @Description:车位操作类
 * @Author: 李栓
 * @Version: V1.00
 * @Create Date: 2017年4月14日 下午5:29:21
 */

@Repository("CarPositionMessageDAO")
@Transactional
public class CarPositionMessageDAOImpl implements CarPositionMessageDAO {

	DbHelper db = new DbHelper();

	public CarPositionMessageDAOImpl() {
		if (null == db) {
			db = new DbHelper();
		}
	}

	@Override
	public ReturnResultEntity addCarPositionMessage(CarPositionMessageEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v = new ArrayList<Object>();
		sql = "insert into carpositionmessage(id,carpositioncode,positionprice,unit,addtime,status,userid,carpositionid) values(?,?,?,?,?,?,?,?)";
		if (ToolUtil.IsEmptyOrNull(item.getId())) {
			item.setId(ToolUtil.GetRandId());
		}
		v.add(item.getId());
		v.add(item.getCarpositioncode());
		v.add(item.getPositionprice());
		v.add(item.getUnit());
		v.add(item.getAddtime());
		v.add(item.getStatus());
		v.add(item.getUserid());
		v.add(item.getCarpositionid());
		List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		v = new ArrayList<Object>();
		sql="update carposition set carpositionstatus=1 where id=?";
		v.add(item.getCarpositionid());
		list = new ArrayList<SqlCommandEntity>();
		list.add(new SqlCommandEntity(sql, v));
		result = db.Execute(list);
		return result;
	}
	@Override
	public ReturnResultEntity updateCarPositionMessage(CarPositionMessageEntity item) {
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
	public ReturnResultEntity delCarPositionMessage(CarPositionMessageEntity item) {
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
	public CarPositionMessageEntity getOneCarPositionMessageModel(String id) {
		CarPositionMessageEntity result = new CarPositionMessageEntity();
			String sql = "select * from user where userid=? and status=0";
			List<Object> value = new ArrayList<Object>();
			value.add(id);
			List<CarPositionMessageEntity> list = db.Query(new SqlCommandEntity(sql, value),
					CarPositionMessageEntity.class);
			if (list.size() == 0) {
				return new CarPositionMessageEntity();
			}
			result = list.get(0);
			return result;
		}
	@Override
	public List<CarPositionMessageEntity> getListCarPositionMessage(SearchBaseEntity sbitem) {
		String sql = "select * from carposition where status=0 group by unit";
		List<CarPositionMessageEntity> result = db.Query(new SqlCommandEntity(sql),
				CarPositionMessageEntity.class);
		return result;
	}
	@Override
	public List<CarPositionMessageEntity> getListCarPositionMessageRecordByPage(SearchBaseEntity sbitem) {
		String sql = "select *,";
				sql+="(select carpositionstatus from carposition where id=carpositionmessage.carpositionid)as carpositionstatus,";
				sql+="(select username from user where userid=carpositionmessage.userid) as username";
				sql+= " from carpositionmessage where status=0";
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
		List<CarPositionMessageEntity> result = db.Query(new SqlCommandEntity(sql),
				CarPositionMessageEntity.class);
		return result;
	}

	

	@Override
	public int getListCarPositionMessageRecordCount(SearchBaseEntity sbitem) {
		String sql = "select count(0) from carpositionmessage where status=0";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		int count = db.GetInt(new SqlCommandEntity(sql));
		return count;
	}
	
}
