package com.slp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.slp.entity.SqlCommandEntity;
import com.slp.toolutil.ToolUtil;
import com.slp.dao.HousingDAO;
import com.slp.entity.HousingEntity;
import com.slp.entity.HousingMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;


/**
 * @Description:楼宇操作类
 * @Author: 李栓
 * @Version: V1.00
 * @Create Date: 2017年4月14日 下午5:29:21
 */

@Repository("HousingDAO")
@Transactional
public class HousingDAOImpl implements HousingDAO {

	DbHelper db = new DbHelper();

	public HousingDAOImpl() {
		if (null == db) {
			db = new DbHelper();
		}
	}

	@Override
	public ReturnResultEntity addhousing(HousingEntity item) {
		ReturnResultEntity result = new ReturnResultEntity();
		String sql = "";
		List<Object> v;
		sql = "select count(0) from housing where unit=? and status=0";
		v = new ArrayList<Object>();
		v.add(item.getUnit());
		int count = db.GetInt(new SqlCommandEntity(sql, v));
		if (count > 0) {
			result.getFailureInfo(item.getUnit() + "单元已经添加！");
			return result;
		}else{
			if(item.getFloors()>0){
					for(int i=1;i<=item.getFloors();i++){
						v = new ArrayList<Object>();
						sql = "insert into housing(id,unit,floors,status,addtime) values(?,?,?,?,?)";
						item.setId(null);
						if (ToolUtil.IsEmptyOrNull(item.getId())) {
							item.setId(ToolUtil.GetRandId());
						}
						v.add(item.getId());
						v.add(item.getUnit());
						v.add(i);
						v.add(item.getStatus());
						v.add(item.getAddtime());
						List<SqlCommandEntity> list = new ArrayList<SqlCommandEntity>();
						list.add(new SqlCommandEntity(sql, v));
						result = db.Execute(list);
					}
					
			}
		}
		return result;
		

	}
	@Override
	public ReturnResultEntity updatehousing(HousingEntity item) {
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
	public ReturnResultEntity delhousing(HousingEntity item) {
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
	public HousingEntity getOnehousingModel(String id) {
		HousingEntity result = new HousingEntity();
			String sql = "select * from user where userid=? and status=0";
			List<Object> value = new ArrayList<Object>();
			value.add(id);
			List<HousingEntity> list = db.Query(new SqlCommandEntity(sql, value),
					HousingEntity.class);
			if (list.size() == 0) {
				return new HousingEntity();
			}
			result = list.get(0);
			return result;
		}
	@Override
	public List<HousingEntity> getListhousing(SearchBaseEntity sbitem) {
			String sql = "select * from housing where status=0 group by unit";
			List<HousingEntity> result = db.Query(new SqlCommandEntity(sql),
					HousingEntity.class);
			return result;
	}
	@Override
	public List<HousingEntity> getListhousingfloors(SearchBaseEntity sbitem) {
			String sql = "select * from housing where status=0 ";
			if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
				sql += " and " + sbitem.getWhere();
			}
			List<HousingEntity> result = db.Query(new SqlCommandEntity(sql),
					HousingEntity.class);
			return result;
	}
	//未租房间
	@Override
	public List<HousingMessageEntity> getListhousinghome(SearchBaseEntity sbitem) {
			String sql = "SELECT * FROM housingmessage WHERE  status=0 and homestatus=0";
			if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
				sql += " and " + sbitem.getWhere();
			}
			List<HousingMessageEntity> result = db.Query(new SqlCommandEntity(sql),
					HousingMessageEntity.class);
			return result;
	}
	//已租房间
	@Override
	public List<HousingMessageEntity> getListhousinghome1(SearchBaseEntity sbitem) {
		String sql = "SELECT * FROM housingmessage WHERE  status=0 and homestatus=1";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		List<HousingMessageEntity> result = db.Query(new SqlCommandEntity(sql),
				HousingMessageEntity.class);
		return result;
	}
	@Override
	public List<HousingMessageEntity> getListhousinghometype(SearchBaseEntity sbitem) {
			String sql = "SELECT * FROM housingmessage WHERE  status=0 ";
			if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
				sql += " and " + sbitem.getWhere();
			}
			List<HousingMessageEntity> result = db.Query(new SqlCommandEntity(sql),
					HousingMessageEntity.class);
			return result;
	}
	@Override
	public List<HousingEntity> getListhousingRecordByPage(SearchBaseEntity sbitem) {
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
		List<HousingEntity> result = db.Query(new SqlCommandEntity(sql),
				HousingEntity.class);
		return result;
	}

	

	@Override
	public int getListhousingRecordCount(SearchBaseEntity sbitem) {
		String sql = "select count(0) from user where status=0";
		if (!ToolUtil.IsEmptyOrNull(sbitem.getWhere())) {
			sql += " and " + sbitem.getWhere();
		}
		int count = db.GetInt(new SqlCommandEntity(sql));
		return count;
	}

	
	
}
