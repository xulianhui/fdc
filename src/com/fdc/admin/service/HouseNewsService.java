package com.fdc.admin.service;

import java.util.List;

import com.fdc.dao.HouseNewsDAO;
import com.fdc.pojo.HouseNews;

public class HouseNewsService {
	private HouseNewsDAO houseNewsDAO;
		
	public List<HouseNews> getAllHouse() {
		return houseNewsDAO.findAll();
	}
	
	public List<HouseNews> getHouseListByUserID(int userID) {
		return houseNewsDAO.findByUserId(userID);
	}
	
	public HouseNews getHouseByID(int houseID) {
		return houseNewsDAO.findById(houseID);
	}
	
	public void checkHouse(int houseID) {
		HouseNews houseNew = getHouseByID(houseID);
		houseNew.setHouseNewsStatus(1);
		houseNewsDAO.update(houseNew);
	}	

	public HouseNewsDAO getHouseNewsDAO() {
		return houseNewsDAO;
	}

	public void setHouseNewsDAO(HouseNewsDAO houseNewsDAO) {
		this.houseNewsDAO = houseNewsDAO;
	}
	
	public void deleteHouseNews(int houseID) {
		HouseNews houseNews = houseNewsDAO.findById(houseID);
		houseNewsDAO.delete(houseNews);
	}
}
