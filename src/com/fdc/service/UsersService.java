package com.fdc.service;

import antlr.collections.List;

import com.fdc.dao.UsersDAO;
import com.fdc.pojo.Users;

public class UsersService {
	UsersDAO usersDAO;

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	public void UpdateUserInfo (Users usr) {
		usersDAO.update(usr);
	}
	
	public Users getUserById(int _id) {
		
		return null;
	}

}
