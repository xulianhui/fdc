package com.fdc.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fdc.pojo.Collections;
import com.fdc.pojo.Comments;
import com.fdc.pojo.HouseNews;
import com.fdc.pojo.Users;
import com.fdc.service.CollectService;
import com.fdc.service.DetailService;
import com.fdc.util.Pair;
import com.opensymphony.xwork2.ActionContext;

public class DetailAction {
	private HouseNews housenews;
	private List<Comments> comments;
	private List<Users> allUsers;
	List<Pair<Comments, Users>> list;
	private int newsId;
	private DetailService service;
	int collect;

	CollectService collectService;

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

		System.out
				.println("----------------------------------------------------------------------");
		housenews = service.show(newsId);
		comments = service.shows(newsId);
		allUsers = new ArrayList<Users>();
		for (int i = 0; i < comments.size(); ++i) {
			allUsers.add(service.getUser(comments.get(i).getComterId()));
		}

		list = new ArrayList<Pair<Comments, Users>>();
		for (int i = 0; i < allUsers.size(); ++i) {
			list.add(new Pair<Comments, Users>(comments.get(i), allUsers.get(i)));
		}

		int userId = ((Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user")).getId();

		int houseNewsId = housenews.getId();
		collect = collectService.checkCollect(new Collections(userId,
				houseNewsId));
		System.out.printf("----------------%d %d %d\n", userId, houseNewsId,
				collect);
		
		
		return "success";
	}

}
