package com.fdc.action;

import java.util.ArrayList;
import java.util.List;

import com.fdc.pojo.Comments;
import com.fdc.pojo.HouseNews;
import com.fdc.pojo.Users;
import com.fdc.service.DetailService;
import com.fdc.util.Pair;

public class DetailAction {
	private HouseNews housenews;
	private List<Comments> comments;
	private List<Users> allUsers;
	List<Pair<Comments, Users>> list;
	private int newsId;
	private DetailService service;

	
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
		
		System.out.println("----------------------------------------------------------------------");
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
		return "success";
	}

}
