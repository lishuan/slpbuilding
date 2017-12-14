package com.slp.service;
import java.util.List;

import com.slp.entity.RegisterEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.entity.UserEntity;

public interface RegisterService {

	// [start]登记信息管理
	public ReturnResultEntity addregister(RegisterEntity item);

	public ReturnResultEntity updateregister(RegisterEntity item);

	public ReturnResultEntity delregister(RegisterEntity item);

	public RegisterEntity getOneregisterModel(String id);

	public List<RegisterEntity> getListregisterRecordByPage(SearchBaseEntity sbitem);

	public List<RegisterEntity> getListregister(SearchBaseEntity sbitem);

	public int getListregisterRecordCount(SearchBaseEntity sbitem);



	// [end]

	
}
