package com.fdc.service;

import com.fdc.dao.HouseNewsDAO;
import com.fdc.pojo.HouseNews;

public class HouseNewsService {
	HouseNewsDAO houseNewsDAO;

	public HouseNewsDAO getHouseNewsDAO() {
		return houseNewsDAO;
	}

	public void setHouseNewsDAO(HouseNewsDAO houseNewsDAO) {
		this.houseNewsDAO = houseNewsDAO;
	}
	
	public HouseNews getHouseNewsById(int id) {
		return houseNewsDAO.findById(id);
	}
}