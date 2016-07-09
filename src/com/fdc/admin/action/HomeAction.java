package com.fdc.admin.action;

import java.util.List;

import com.fdc.admin.pojo.HouseNews;
import com.fdc.admin.service.HomepageService;
import com.fdc.admin.service.HouseNewsService;
import com.opensymphony.xwork2.Action;

public class HomeAction implements Action {
	private HomepageService homepageService;
	private HouseNewsService houseNewsService;

	public HomepageService getHomepageService() {
		return homepageService;
	}

	public void setHomepageService(HomepageService homepageService) {
		this.homepageService = homepageService;
	}

	public HouseNewsService getHouseNewsService() {
		return houseNewsService;
	}

	public void setHouseNewsService(HouseNewsService houseNewsService) {
		this.houseNewsService = houseNewsService;
	}

	private List<HouseNews> houseList;

	public String load() {
		String result;
		try {
			houseList = houseNewsService.getAllHouse();
			result = SUCCESS;
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	private Integer houseID;
	private Integer toID;

	private int[] index = new int[] { 0, 1, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14,
			15, 16, 17, 18 };

	public String post() {
		String result;
		try {
			result = SUCCESS;
			System.out.printf("%d -> %d\n", houseID, index[toID]);
			homepageService.post(houseID, index[toID]);
		}
		catch (Exception exception) {
			result = ERROR;
		}
		return result;
	}

	public List<HouseNews> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<HouseNews> houseList) {
		this.houseList = houseList;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getHouseID() {
		return houseID;
	}

	public void setHouseID(Integer houseID) {
		this.houseID = houseID;
	}

	public Integer getToID() {
		return toID;
	}

	public void setToID(Integer toID) {
		this.toID = toID;
	}
}
