package com.fdc.service;

import java.util.List;

import com.fdc.dao.HomepageDAO;
import com.fdc.pojo.Homepage;


public class HomepageService {
	
	private HomepageDAO homepageDAO;
	private Homepage homepage;
	
	public List<Homepage> show() {
		System.out.println("service执行");
		List<Homepage> list = getHomepageDAO().findAll();
		if(list.size() > 0)
			return list;
		return null;
	
	}
	public Homepage getHomepage() {
		return homepage;
	}
	public void setHomepage(Homepage homepage) {
		this.homepage = homepage;
	}
	public HomepageDAO getHomepageDAO() {
		return homepageDAO;
	}
	public void setHomepageDAO(HomepageDAO homepageDAO) {
		this.homepageDAO = homepageDAO;
	}
	
}