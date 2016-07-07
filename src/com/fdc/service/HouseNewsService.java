package com.fdc.service;

import java.util.List;

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

	public List getHouseNewsByUserId(int userId) {
		return houseNewsDAO.findByUserId(userId);
	}

	public void shelvesHouseById(int id) {
		HouseNews tmp = houseNewsDAO.findById(id);
		tmp.setHouseNewsStatus(1);
		houseNewsDAO.update(tmp);
	}

	public String add(HouseNews housenew) {
		String result = houseNewsDAO.savenew(housenew);
		if (result != null)
			return "success";
		return "fail";
	}
}
