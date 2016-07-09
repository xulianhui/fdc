package com.fdc.admin.action;

import java.util.ArrayList;
import java.util.List;

import com.fdc.admin.pojo.HouseNews;
import com.fdc.admin.service.HouseNewsService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class HouseNewsAction implements Action {

	// Spring
	private HouseNewsService houseNewsService;
	private List<HouseNews> houseList;

	public String initLoad() {
		String result;
		try {
			result = SUCCESS;
			houseList = houseNewsService.getAllHouse();
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	private Integer cekHouseID;

	public String check() {
		String result;
		try {
			result = SUCCESS;
			houseNewsService.checkHouse(getCekHouseID());
			houseList = houseNewsService.getAllHouse();
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	private Integer delHouseID;

	public String delete() {
		String result;
		try {
			result = SUCCESS;
			houseNewsService.deleteHouseNews(getDelHouseID());
			houseList = houseNewsService.getAllHouse();
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	public Integer shHouseID;
	
	public String toID() {
		String result;
		try {
			result = SUCCESS;
			ActionContext.getContext().put("shForm", SH_BYID);
			houseList = null;
		}
		catch(Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}
	
	public String toUser() {
		String result;
		try {
			result = SUCCESS;
			ActionContext.getContext().put("shForm", SH_BYUSER);
			houseList = null;
		}
		catch(Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	public String shByID() {
		String result;
		try {
			result = SUCCESS;
			houseList = new ArrayList<HouseNews>();
			houseList.add(houseNewsService.getHouseByID(shHouseID));
			ActionContext.getContext().put("shForm", SH_BYID);
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	public Integer shUserID;

	public String shByUserID() {
		String result;
		try {
			result = SUCCESS;
			houseList = houseNewsService.getHouseListByUserID(shUserID);
			ActionContext.getContext().put("shForm", SH_BYUSER);
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	private static final String SH_BYID = "<form action=\"HouseNews-shByID\" method=\"post\" class=\"form-inline\">"
			+ "信息 ID："
			+ "<input type=\"text\" name=\"shHouseID\" class=\"form-control\" />"
			+ "<input type=\"submit\" value=\"查找信息\" class=\"btn btn-default\" /> "
			+ "</form>";

	private static final String SH_BYUSER = "<form action=\"HouseNews-shByUserID\" method=\"post\" class=\"form-inline\">"
			+ "发布用户 ID："
			+ "<input type=\"text\" name=\"shUserID\" class=\"form-control\" />"
			+ "<input type=\"submit\" value=\"查找信息\" class=\"btn btn-default\" /> "
			+ "</form>";

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public HouseNewsService getHouseNewsService() {
		return houseNewsService;
	}

	public void setHouseNewsService(HouseNewsService houseNewsService) {
		this.houseNewsService = houseNewsService;
	}

	public List<HouseNews> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<HouseNews> houseList) {
		this.houseList = houseList;
	}

	public Integer getCekHouseID() {
		return cekHouseID;
	}

	public void setCekHouseID(Integer cekHouseID) {
		this.cekHouseID = cekHouseID;
	}

	public Integer getDelHouseID() {
		return delHouseID;
	}

	public void setDelHouseID(Integer delHouseID) {
		this.delHouseID = delHouseID;
	}

}
