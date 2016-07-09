package com.fdc.admin.service;

import com.fdc.dao.HomepageDAO;
import com.fdc.dao.HouseNewsDAO;
import com.fdc.pojo.HouseNews;
import com.fdc.pojo.Homepage;

public class HomepageService {
	private HomepageDAO homepageDAO;
	private HouseNewsDAO houseNewsDAO;

	public HomepageDAO getHomepageDAO() {
		return homepageDAO;
	}

	public void setHomepageDAO(HomepageDAO homepageDAO) {
		this.homepageDAO = homepageDAO;
	}
	
	public void update(Homepage page) {
		homepageDAO.update(page);
	}
	
	public void post(int houseID, int toID) {
		HouseNews house = houseNewsDAO.findById(houseID);
		Homepage home = homepageDAO.findById(toID);
		System.out.println(house);
		System.out.println(home);
		System.out.println("%% debug %%");
		home.setPicadd(house.getImg1());
		home.setRemarks(house.getHouseTitle());
		home.setHouseNewsId(houseID);
		homepageDAO.update(home);
	}

	public HouseNewsDAO getHouseNewsDAO() {
		return houseNewsDAO;
	}

	public void setHouseNewsDAO(HouseNewsDAO houseNewsDAO) {
		this.houseNewsDAO = houseNewsDAO;
	}
}
