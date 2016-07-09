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
		List<Users> list = usersDAO.findByEmailPwd(users);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public int getid(String email) {
		System.out.println("serviceִ��");
		List<Users> list = usersDAO.findByEmail(email);
		if (list.size() > 0) {
			return list.get(0).getId();
		} else {
			return 0;
		}
	}

	public boolean regedit(Users users) {
		// TODO Auto-generated method stub
		if (usersDAO.queryByemail(users.getEmail()) == null) { // �ж��û����Ƿ�ռ��
			usersDAO.savenew(users); // �����û�
			return true; // ����ɹ�
		} else {
			return false; // ����ʧ��
		}
	}

	public boolean checkemail(String email) {
		// TODO Auto-generated method stub
		if (usersDAO.queryByemail(email) == null) { // �ж��û����Ƿ�ռ��
			return true; // check�ɹ�
		} else {
			return false; // checkʧ��
		}
	}

	public Users getUsersByEmail(String Email) {

		List aList = usersDAO.findByEmail(Email);

		return (Users) aList.get(0);

	}

}
