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
		return recordRentDAO.findByHouseNewsId(_id);
	}
	
	public void agree(int _id) {
		RecordRent recordRent = recordRentDAO.findById(_id);
		recordRent.setRecordState(1);
		recordRentDAO.update(recordRent);
		
	}
	
	public void refuse(int _id) {
		System.out.println("进入拒绝交易 in service");
		RecordRent recordRent = recordRentDAO.findById(_id);
		recordRent.setRecordState(3);
		recordRentDAO.update(recordRent);
		System.out.println("拒绝交易成功 in service");
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

	public void cancle(int recordId) {
		// TODO Auto-generated method stub
		RecordRent recordRent = recordRentDAO.findById(recordId);
		if (recordRent == null) {
			System.err.println("recordRent 空指针");
			return;
		}
		recordRent.setRecordState(2);
		recordRentDAO.update(recordRent);
	}
}
