package com.slp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slp.dao.CarPositionDAO;
import com.slp.dao.UserDAO;
import com.slp.entity.CarPositionEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.entity.UserEntity;
import com.slp.service.CarPositionService;
import com.slp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	

	@Override
	public ReturnResultEntity adduser(UserEntity item) {
		// TODO Auto-generated method stub
		return dao.adduser(item);
	}

	@Override
	public ReturnResultEntity updateuser(UserEntity item) {
		// TODO Auto-generated method stub
		return dao.updateuser(item);
	}

	@Override
	public ReturnResultEntity deluser(UserEntity item) {
		// TODO Auto-generated method stub
		return dao.deluser(item);
	}

	@Override
	public UserEntity getOneUserModel(String id) {
		// TODO Auto-generated method stub
		return dao.getOneUserModel(id);
	}

	@Override
	public List<UserEntity> getListUserRecordByPage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListUserRecordByPage(sbitem);
	}

	@Override
	public List<UserEntity> getListUser(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListUser(sbitem);
	}

	@Override
	public int getListUserRecordCount(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListUserRecordCount(sbitem);
	}

	
	

}
