package com.slp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slp.dao.CarPositionMessageDAO;
import com.slp.entity.CarPositionMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.service.CarPositionMessageService;

@Service
public class CarPositionMessageServiceImpl implements CarPositionMessageService {

	@Autowired
	private CarPositionMessageDAO dao;

	@Override
	public ReturnResultEntity addCarPositionMessage(CarPositionMessageEntity item) {
		// TODO Auto-generated method stub
		return dao.addCarPositionMessage(item);
	}

	@Override
	public ReturnResultEntity updateCarPositionMessage(CarPositionMessageEntity item) {
		// TODO Auto-generated method stub
		return dao.updateCarPositionMessage(item);
	}

	@Override
	public ReturnResultEntity delCarPositionMessage(CarPositionMessageEntity item) {
		// TODO Auto-generated method stub
		return dao.delCarPositionMessage(item);
	}

	@Override
	public CarPositionMessageEntity getOneCarPositionMessageModel(String id) {
		// TODO Auto-generated method stub
		return dao.getOneCarPositionMessageModel(id);
	}

	@Override
	public List<CarPositionMessageEntity> getListCarPositionMessageRecordByPage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListCarPositionMessageRecordByPage(sbitem);
	}

	@Override
	public List<CarPositionMessageEntity> getListCarPositionMessage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListCarPositionMessage(sbitem);
	}

	@Override
	public int getListCarPositionMessageRecordCount(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListCarPositionMessageRecordCount(sbitem);
	}
	

}
