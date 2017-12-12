package com.slp.dao;
import java.util.List;

import com.slp.entity.SearchBaseEntity;
import com.slp.entity.HousingEntity;
import com.slp.entity.HousingMessageEntity;
import com.slp.entity.ReturnResultEntity;

public interface HousingDAO {
	// [start]楼宇信息管理
		public ReturnResultEntity addhousing(HousingEntity item);

		public ReturnResultEntity updatehousing(HousingEntity item);

		public ReturnResultEntity delhousing(HousingEntity item);

		public HousingEntity getOnehousingModel(String id);

		public List<HousingEntity> getListhousingRecordByPage(SearchBaseEntity sbitem);

		public List<HousingEntity> getListhousing(SearchBaseEntity sbitem);

		public int getListhousingRecordCount(SearchBaseEntity sbitem);

		public List<HousingEntity> getListhousingfloors(SearchBaseEntity sbitem);
		public List<HousingMessageEntity> getListhousinghome(SearchBaseEntity sbitem);

		public List<HousingMessageEntity> getListhousinghometype(SearchBaseEntity sbitem);

		public List<HousingMessageEntity> getListhousinghome1(SearchBaseEntity sbitem);
		

		// [end]
}
