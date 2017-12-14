package com.slp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slp.dao.RegisterDAO;
import com.slp.entity.RegisterEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO dao;

	@Override
	public ReturnResultEntity addregister(RegisterEntity item) {
		// TODO Auto-generated method stub
		return dao.addregister(item);
	}

	@Override
	public ReturnResultEntity updateregister(RegisterEntity item) {
		// TODO Auto-generated method stub
		return dao.updateregister(item);
	}

	@Override
	public ReturnResultEntity delregister(RegisterEntity item) {
		// TODO Auto-generated method stub
		return dao.delregister(item);
	}

	@Override
	public RegisterEntity getOneregisterModel(String id) {
		// TODO Auto-generated method stub
		return dao.getOneregisterModel(id);
	}

	@Override
	public List<RegisterEntity> getListregisterRecordByPage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListregisterRecordByPage(sbitem);
	}

	@Override
	public List<RegisterEntity> getListregister(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListregister(sbitem);
	}

	@Override
	public int getListregisterRecordCount(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListregisterRecordCount(sbitem);
	}

	

	

	
	

}
