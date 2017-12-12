package com.slp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slp.dao.HousingDAO;
import com.slp.entity.HousingEntity;
import com.slp.entity.HousingMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.service.HousingService;

@Service
public class HousingServiceImpl implements HousingService {

	@Autowired
	private HousingDAO dao;

	@Override
	public ReturnResultEntity addhousing(HousingEntity item) {
		// TODO Auto-generated method stub
		return dao.addhousing(item);
	}

	@Override
	public ReturnResultEntity updatehousing(HousingEntity item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnResultEntity delhousing(HousingEntity item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HousingEntity getOnehousingModel(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HousingEntity> getListhousingRecordByPage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HousingEntity> getListhousing(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListhousing(sbitem);
	}
	@Override
	public List<HousingEntity> getListhousingfloors(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListhousingfloors(sbitem);
	}
	@Override
	public int getListhousingRecordCount(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HousingMessageEntity> getListhousinghome(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListhousinghome(sbitem);
	}

	@Override
	public List<HousingMessageEntity> getListhousinghometype(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListhousinghometype(sbitem);
	}

	@Override
	public List<HousingMessageEntity> getListhousinghome1(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListhousinghome1(sbitem);
	}

	

}
