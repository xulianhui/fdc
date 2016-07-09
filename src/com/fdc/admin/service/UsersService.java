package com.fdc.admin.service;

import java.util.List;

import com.fdc.dao.UsersDAO;
import com.fdc.pojo.Users;

public class UsersService {
	private UsersDAO usersDAO;

	public List<Users> getUserList(String userName) {
		return usersDAO.findByNickName(userName);
	}

	public List<Users> getUserList() {
		return usersDAO.findAll();
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}
	
	public List<Users> getUsersByEmail(String email) {
		return usersDAO.findByEmail(email);
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public void deleteUser(int userId) {
		try {
			Users user = usersDAO.findById(userId);
			if (null == user) {
				System.err.println("Can not find user with id: " + userId);
			}
			else {
				usersDAO.delete(user);
			}
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
		}
	}
	
	public Users getUser(int userID) {
		return usersDAO.findById(userID);
	}
	
	public void save(Users user) {
		usersDAO.save(user);
	}
	
	public void check(int userID) {
		Users user = usersDAO.findById(userID);
		user.setChecked(true);
		usersDAO.update(user);
	}
}
