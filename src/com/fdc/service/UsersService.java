package com.fdc.service;

import java.util.*;

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

	// --------------------------------------------------------------------
	public void UpdateUserInfo(Users usr) {
		usersDAO.update(usr);
	}

	public Users getUserById(int _id) {
		return usersDAO.findById(_id);
	}

	public Users login(Users users) {
		System.out.println("service执行");
		List<Users> list = usersDAO.findByEmailPwd(users);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public int getid(String email) {
		System.out.println("service执行");
		List<Users> list = usersDAO.findByEmail(email);
		if (list.size() > 0) {
			return list.get(0).getId();
		} else {
			return 0;
		}
	}

	public boolean regedit(Users users) {
		// TODO Auto-generated method stub
		if (usersDAO.queryByemail(users.getEmail()) == null) { // 判断用户名是否被占用
			usersDAO.savenew(users); // 保存用户
			return true; // 保存成功
		} else {
			return false; // 保存失败
		}
	}

	public boolean checkemail(String email) {
		// TODO Auto-generated method stub
		if (usersDAO.queryByemail(email) == null) { // 判断用户名是否被占用
			return true; // check成功
		} else {
			return false; // check失败
		}
	}

}
