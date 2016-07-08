package com.fdc.service;

import com.fdc.dao.RecordRentDAO;
import com.fdc.pojo.RecordRent;

import java.util.*;

public class RecordRentService {
	RecordRentDAO recordRentDAO;

	public RecordRentDAO getRecordRentDAO() {
		return recordRentDAO;
	}

	public void setRecordRentDAO(RecordRentDAO recordRentDAO) {
		this.recordRentDAO = recordRentDAO;
	}

	public List getRecordListByHouseUserId(int _id) {
		return recordRentDAO.findByHouseUserId(_id);
	}

	public List getRecordListByHouseNewsId(int _id) {
		return recordRentDAO.findByHouseUserId(_id);
	}
	
	public void agree(int _id) {
		RecordRent recordRent = recordRentDAO.findById(_id);
		if(recordRent == null) {
			return ;
		} else recordRent.setRecordState(1);
		
	}
	
	public void refuse(int _id) {
		RecordRent recordRent = recordRentDAO.findById(_id);
		recordRent.setRecordState(3);
	}
	
	public RecordRent getRecordRentById(int id) {
		return recordRentDAO.findById(id);
	}
	
	public void save(RecordRent recordRent) {
		recordRentDAO.save(recordRent);
	}
	public void update(RecordRent recordRent) {
		recordRentDAO.update(recordRent);
	}
}
