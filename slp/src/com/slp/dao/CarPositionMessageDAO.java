package com.slp.dao;
import java.util.List;

import com.slp.entity.SearchBaseEntity;
import com.slp.entity.CarPositionEntity;
import com.slp.entity.CarPositionMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.UserEntity;

public interface CarPositionMessageDAO {
	// [start]车位信息管理
		public ReturnResultEntity addCarPositionMessage(CarPositionMessageEntity item);

		public ReturnResultEntity updateCarPositionMessage(CarPositionMessageEntity item);

		public ReturnResultEntity delCarPositionMessage(CarPositionMessageEntity item);

		public CarPositionMessageEntity getOneCarPositionMessageModel(String id);

		public List<CarPositionMessageEntity> getListCarPositionMessageRecordByPage(SearchBaseEntity sbitem);

		public List<CarPositionMessageEntity> getListCarPositionMessage(SearchBaseEntity sbitem);

		public int getListCarPositionMessageRecordCount(SearchBaseEntity sbitem);
		// [end]
}
