package com.slp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.slp.entity.SqlCommandEntity;
import com.slp.toolutil.ToolUtil;
import com.slp.dao.CarPositionDAO;
import com.slp.entity.CarPositionEntity;
import com.slp.entity.HousingEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;


/**
 * @Description:车位操作类
 * @Author: 李栓
 * @Version: V1.00
 * @Create Date: 2017年4月14日 下午5:29:21
 */

@Repository("CarPositionDAO")
@Transactional
public class CarPositionDAOImpl implements CarPositionDAO {

	DbHelper db = new DbHelper();

	public CarPositionDAOImpl() {
		if (null == db) {
			db = new DbHelper();
		}
	}

	@Override
	public ReturnResultEntity addCarPosition(CarPositionEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v = new ArrayList<Object>();
		if(item.getCarpositionsum()>0){
			for(int i=1;i<=item.getCarpositionsum();i++){
				v = new ArrayList<Object>();
				sql = "insert into carposition(id,carpositionstatus,carpositioncode,unit,addtime,status) values(?,?,?,?,?,?)";
				item.setId(null);
				if (ToolUtil.IsEmptyOrNull(item.getId())) {
					item.setId(ToolUtil.GetRandId());
				}
				v.add(item.getId());
				v.add(item.getCarpositionstatus());
				v.add(i);//从1开始为车位编号
				v.add(item.getUnit());
				v.add(item.getAddtime());
				v.add(item.getStatus());
				List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
				list.add(new SqlCommandEntity(sql, v));
				result = db.Execute(list);
				
			}
		}
		return result;
	}
	@Override
	public ReturnResultEntity updateCarPosition(CarPositionEntity item) {
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
	public ReturnResultEntity delCarPosition(CarPositionEntity item) {
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
	public CarPositionEntity getOneCarPositionModel(String id) {
		CarPositionEntity result = new CarPositionEntity();
			String sql = "select * from user where userid=? and status=0";
			List<Object> value = new ArrayList<Object>();
			value.add(id);
			List<CarPositionEntity> list = db.Query(new SqlCommandEntity(sql, value),
					CarPositionEntity.class);
			if (list.size() == 0) {
				return new CarPositionEntity();
			}
			result = list.get(0);
			return result;
		}
	@Override
	public List<CarPositionEntity> getListCarPosition(SearchBaseEntity sbitem) {
		String sql = "select * from carposition where status=0 group by unit";
		List<CarPositionEntity> result = db.Query(new SqlCommandEntity(sql),
				CarPositionEntity.class);
		return result;
	}
	@Override
	public List<CarPositionEntity> getListCarPositionRecordByPage(SearchBaseEntity sbitem) {
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
		List<CarPositionEntity> result = db.Query(new SqlCommandEntity(sql),
				CarPositionEntity.class);
		return result;
	}

	

	@Override
	public int getListCarPositionRecordCount(SearchBaseEntity sbitem) {
		String sql = "select count(0) from user where status=0";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		int count = db.GetInt(new SqlCommandEntity(sql));
		return count;
	}

	@Override
	public List<CarPositionEntity> getListcarpositioncode(SearchBaseEntity sbitem) {
		String sql = "select * from carposition where status=0 and carpositionstatus=0";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		List<CarPositionEntity> result = db.Query(new SqlCommandEntity(sql),
				CarPositionEntity.class);
		return result;
	}

	@Override
	public List<CarPositionEntity> getListcarpositioncode1(SearchBaseEntity sbitem) {
		String sql = "select * from carposition where status=0 and carpositionstatus=1";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		List<CarPositionEntity> result = db.Query(new SqlCommandEntity(sql),
				CarPositionEntity.class);
		return result;
	}
	
}
