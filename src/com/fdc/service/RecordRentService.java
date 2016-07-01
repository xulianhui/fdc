package com.fdc.service;

import com.fdc.dao.RecordRentDAO;

import java.util.*;

public class RecordRentService {
	RecordRentDAO recordRentDAO;
	public RecordRentDAO getRecordRentDAO() {
		return recordRentDAO;
	}
	public void setRecordRentDAO(RecordRentDAO recordRentDAO) {
		this.recordRentDAO = recordRentDAO;
	}
	public List getRecordListByHouseUserId (int _id) {
		return recordRentDAO.findByHouseNewsId(_id);
	}
}
