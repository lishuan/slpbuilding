package com.slp.dao;
import java.util.List;

import com.slp.entity.SearchBaseEntity;

import com.slp.entity.ReturnResultEntity;
import com.slp.entity.UserEntity;

public interface UserDAO {
	// [start]用户信息管理
		public ReturnResultEntity adduser(UserEntity item);

		public ReturnResultEntity updateuser(UserEntity item);

		public ReturnResultEntity deluser(UserEntity item);

		public UserEntity getOneUserModel(String id);

		public List<UserEntity> getListUserRecordByPage(SearchBaseEntity sbitem);

		public List<UserEntity> getListUser(SearchBaseEntity sbitem);

		public int getListUserRecordCount(SearchBaseEntity sbitem);


		// [end]
}
