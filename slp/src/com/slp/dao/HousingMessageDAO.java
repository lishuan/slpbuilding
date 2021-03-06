package com.slp.dao;
import java.util.List;

import com.slp.entity.SearchBaseEntity;
import com.slp.entity.HousingEntity;
import com.slp.entity.HousingMessageEntity;
import com.slp.entity.ReturnResultEntity;

public interface HousingMessageDAO {
	// [start]房间信息管理
		public ReturnResultEntity addhousingmessage(HousingMessageEntity item);

		public ReturnResultEntity updatehousingmessage(HousingMessageEntity item);

		public ReturnResultEntity delhousingmessage(HousingMessageEntity item);

		public HousingMessageEntity getOnehousingmessageModel(String id);

		public List<HousingMessageEntity> getListhousingmessageRecordByPage(SearchBaseEntity sbitem);

		public List<HousingMessageEntity> getListhousingmessage(SearchBaseEntity sbitem);

		public int getListhousingmessageRecordCount(SearchBaseEntity sbitem);


		


		// [end]
}
