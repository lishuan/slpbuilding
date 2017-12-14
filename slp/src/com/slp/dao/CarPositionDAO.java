package com.slp.dao;
import java.util.List;

import com.slp.entity.SearchBaseEntity;
import com.slp.entity.CarPositionEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.UserEntity;

public interface CarPositionDAO {
	// [start]车位信息管理
		public ReturnResultEntity addCarPosition(CarPositionEntity item);

		public ReturnResultEntity updateCarPosition(CarPositionEntity item);

		public ReturnResultEntity delCarPosition(CarPositionEntity item);

		public CarPositionEntity getOneCarPositionModel(String id);

		public List<CarPositionEntity> getListCarPositionRecordByPage(SearchBaseEntity sbitem);

		public List<CarPositionEntity> getListCarPosition(SearchBaseEntity sbitem);

		public int getListCarPositionRecordCount(SearchBaseEntity sbitem);

		public List<CarPositionEntity> getListcarpositioncode(SearchBaseEntity sbitem);

		public List<CarPositionEntity> getListcarpositioncode1(SearchBaseEntity sbitem);

		public List<CarPositionEntity> getmaxcarpositioncode(SearchBaseEntity sbitem);


		// [end]
}
