package com.slp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slp.dao.HousingMessageDAO;
import com.slp.entity.HousingEntity;
import com.slp.entity.HousingMessageEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SearchBaseEntity;
import com.slp.service.HousingMessageService;

@Service
public class HousingMessageServiceImpl implements HousingMessageService {

	@Autowired
	private HousingMessageDAO dao;

	@Override
	public ReturnResultEntity addhousingmessage(HousingMessageEntity item) {
		// TODO Auto-generated method stub
		return dao.addhousingmessage(item);
	}

	@Override
	public ReturnResultEntity updatehousingmessage(HousingMessageEntity item) {
		// TODO Auto-generated method stub
		return dao.updatehousingmessage(item);
	}

	@Override
	public ReturnResultEntity delhousingmessage(HousingMessageEntity item) {
		// TODO Auto-generated method stub
		return dao.delhousingmessage(item);
	}

	@Override
	public HousingMessageEntity getOnehousingmessageModel(String id) {
		// TODO Auto-generated method stub
		return dao.getOnehousingmessageModel(id);
	}

	@Override
	public List<HousingMessageEntity> getListhousingmessageRecordByPage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListhousingmessageRecordByPage(sbitem);
	}

	@Override
	public List<HousingMessageEntity> getListhousingmessage(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListhousingmessage(sbitem);
	}

	@Override
	public int getListhousingmessageRecordCount(SearchBaseEntity sbitem) {
		// TODO Auto-generated method stub
		return dao.getListhousingmessageRecordCount(sbitem);
	}


	

	
	

}
