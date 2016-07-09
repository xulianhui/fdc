package com.fdc.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fdc.pojo.Collections;
import com.fdc.pojo.Comments;
import com.fdc.pojo.HouseNews;
import com.fdc.pojo.RecordRent;
import com.fdc.pojo.Users;
import com.fdc.service.CollectService;
import com.fdc.service.DetailService;
import com.fdc.service.HouseNewsService;
import com.fdc.service.RecordRentService;
import com.fdc.util.Pair;

public class DetailAction {
	private HouseNews housenews;
	private List<Comments> comments;
	private List<Users> allUsers;
	List<Pair<Comments, Users>> list;
	int newsId;
	int houseNewsId;

	private int collect;
	String msg;

	private DetailService service;
	RecordRentService recordRentService;
	CollectService collectService;
	HouseNewsService houseNewsService;
	
	
	public HouseNewsService getHouseNewsService() {
		return houseNewsService;
	}

	public void setHouseNewsService(HouseNewsService houseNewsService) {
		this.houseNewsService = houseNewsService;
	}

	public int getHouseNewsId() {
		return houseNewsId;
	}
	
	public void setHouseNewsId(int houseNewsId) {
		this.houseNewsId = houseNewsId;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public RecordRentService getRecordRentService() {
		return recordRentService;
	}

	public void setRecordRentService(RecordRentService recordRentService) {
		this.recordRentService = recordRentService;
	}

	
	public int getCollect() {
		return collect;
	}

	public void setCollect(int collect) {
		this.collect = collect;
	}

	public CollectService getCollectService() {
		return collectService;
	}

	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}

	public List<Pair<Comments, Users>> getList() {
		return list;
	}

	public void setList(List<Pair<Comments, Users>> list) {
		this.list = list;
	}

	public List<Users> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<Users> allUsers) {
		this.allUsers = allUsers;
	}

	public DetailService getService() {
		return service;
	}

	public void setService(DetailService service) {
		this.service = service;
	}

	public HouseNews getHousenews() {
		return housenews;
	}

	public void setHousenews(HouseNews housenews) {
		this.housenews = housenews;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public String show() {

		System.out.println("newsId : " + newsId + "\n");
		housenews = service.show(newsId);
		if (housenews == null) {
			msg="housenews null pointer";
			return "error";
		}
		comments = service.shows(newsId);
		allUsers = new ArrayList<Users>();
		for (int i = 0; i < comments.size(); ++i) {
			allUsers.add(service.getUser(comments.get(i).getComterId()));
		}

		list = new ArrayList<Pair<Comments, Users>>();
		for (int i = 0; i < allUsers.size(); ++i) {
			list.add(new Pair<Comments, Users>(comments.get(i), allUsers.get(i)));
		}

		int userId = ((Users) ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		int houseNewsId = housenews.getId();
		collect = collectService.checkCollect(new Collections(userId,
				houseNewsId));
		System.out.printf("----------------%d %d %d\n", userId, houseNewsId,
				collect);

		return "success";
	}
	
	public String buyHouse() {
		
//		houseNewsId
		HouseNews houseNews = houseNewsService.getHouseNewsById(houseNewsId);
		if (houseNews.getHouseNewsStatus() != 1) {
			msg = "房屋状态错误";
			return "error";
		}

//		private Integer houseNewsId;
//		private Integer houseUserId;
//		private Integer recordState;
//		private String recordReqTime;
//		private Boolean recordType;
		Date date = new java.util.Date();
		Timestamp addtime = new Timestamp(date.getTime());
		int userId = ((Users) ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		
		RecordRent recordRent = new RecordRent();
		recordRent.setHouseNewsId(houseNewsId);
		recordRent.setHouseUserId(userId);
		recordRent.setRecordReqTime(addtime);
		recordRent.setRecordState(0);
		recordRent.setRecordType(houseNews.getNewsType() == 1);
		
		
		recordRentService.save(recordRent);
		msg="订单已发送，等待商家回应";
		return "success";
	}

}
