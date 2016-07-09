package com.fdc.service;

import java.util.List;

import com.fdc.pojo.HouseNews;
import com.fdc.pojo.Users;
import com.fdc.dao.HouseNewsDAO;
import com.fdc.dao.UsersDAO;
import com.fdc.pojo.Comments;
import com.fdc.dao.CommentsDAO;

public class DetailService {
	private HouseNewsDAO houseNewsDAO;
	private CommentsDAO commentsDAO;
	private UsersDAO usersDAO;

	public HouseNewsDAO getHouseNewsDAO() {
		return houseNewsDAO;
	}

	public void setHouseNewsDAO(HouseNewsDAO housenewsDAO) {
		this.houseNewsDAO = housenewsDAO;
	}

	public CommentsDAO getCommentsDAO() {
		return commentsDAO;
	}

	public void setCommentsDAO(CommentsDAO commentsDAO) {
		this.commentsDAO = commentsDAO;
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public HouseNews show(int houseid) {
		HouseNews housenews = houseNewsDAO.findById(houseid);
		if (housenews != null) {
			return housenews;
		} else {
			return null;
		}
	}

	public List<Comments> shows(int commentsId) {
		List<Comments> comments = commentsDAO.findByComtedId(commentsId);
		if (comments != null) {
			return comments;
		} else {
			return null;
		}
	}

	public Users getUser(Integer comterId) {
		// TODO Auto-generated method stub
		Users name = usersDAO.findById(comterId);
		// System.out.println(name.getNickName());
		if (name != null)
			return name;
		System.out.println("NULL users");
		return null;
	}
}
