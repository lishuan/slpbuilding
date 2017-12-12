package com.slp.dao;
import java.util.List;

import com.slp.entity.SearchBaseEntity;
import com.slp.entity.TenantsMessageEntity;
import com.slp.entity.ReturnResultEntity;

public interface TenantsMessageDAO {
	// [start]租客信息管理
		public ReturnResultEntity addTenantsMessage(TenantsMessageEntity item);

		public ReturnResultEntity updateTenantsMessage(TenantsMessageEntity item);

		public ReturnResultEntity delTenantsMessage(TenantsMessageEntity item);

		public TenantsMessageEntity getOneTenantsMessageModel(String id);

		public List<TenantsMessageEntity> getListTenantsMessageRecordByPage(SearchBaseEntity sbitem);

		public List<TenantsMessageEntity> getListTenantsMessage(SearchBaseEntity sbitem);
		
		public int getListTenantsMessageRecordCount(SearchBaseEntity sbitem);


		// [end]
}
