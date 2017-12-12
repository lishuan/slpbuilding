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
public class CarPositionServiceImpl implements CarPositionService {

	@Autowired
	private CarPositionDAO dao;

	@Override
	public ReturnResultEntity addCarPosition(CarPositionEntity item) {
		// TODO Auto-generated method stub
		return dao.addCarPosition(item);
	}

	@Override
	public ReturnResultEntity updateCarPosition(CarPositionEntity item) {
		// TODO Auto-generated method stub
		return dao.updateCarPosition(item);
	}

	@Override
	public ReturnResultEntity delCarPosition(CarPositionEntity item) {
		// TODO Auto-generated method stub
		return dao.delCarPosition(item);
	}

	@Override
	public CarPositionEntity getOneCarPositionModel(String id) {
		// TODO Auto-generated method stub
		return dao.getOneCarPositionModel(id);
	}

	@Override
	public List<CarPositionEntity> getListCarPositionRecordByPage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListCarPositionRecordByPage(sbitem);
	}

	@Override
	public List<CarPositionEntity> getListCarPosition(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListCarPosition(sbitem);
	}

	@Override
	public int getListCarPositionRecordCount(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListCarPositionRecordCount(sbitem);
	}

	@Override
	public List<CarPositionEntity> getListcarpositioncode(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListcarpositioncode(sbitem);
	}

	@Override
	public List<CarPositionEntity> getListcarpositioncode1(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListcarpositioncode1(sbitem);
	}

	

}
