package com.slp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slp.dao.TenantsMessageDAO;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.entity.TenantsMessageEntity;
import com.slp.service.TenantsMessageService;

@Service
public class TenantsMessageServiceImpl implements TenantsMessageService {

	@Autowired
	private TenantsMessageDAO dao;

	

	@Override
	public ReturnResultEntity addTenantsMessage(TenantsMessageEntity item) {
		// TODO Auto-generated method stub
		return dao.addTenantsMessage(item);
	}

	@Override
	public ReturnResultEntity updateTenantsMessage(TenantsMessageEntity item) {
		// TODO Auto-generated method stub
		return dao.updateTenantsMessage(item);
	}

	@Override
	public ReturnResultEntity delTenantsMessage(TenantsMessageEntity item) {
		// TODO Auto-generated method stub
		return dao.delTenantsMessage(item);
	}

	@Override
	public TenantsMessageEntity getOneTenantsMessageModel(String id) {
		// TODO Auto-generated method stub
		return dao.getOneTenantsMessageModel(id);
	}

	@Override
	public List<TenantsMessageEntity> getListTenantsMessageRecordByPage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListTenantsMessageRecordByPage(sbitem);
	}

	@Override
	public List<TenantsMessageEntity> getListTenantsMessage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListTenantsMessage(sbitem);
	}

	@Override
	public int getListTenantsMessageRecordCount(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListTenantsMessageRecordCount(sbitem);
	}
	

}
