package com.slp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slp.dao.AdminDAO;
import com.slp.entity.AdminEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO dao;
	public ReturnResultEntity login(AdminEntity item) {
		return dao.login(item);
	}

}
