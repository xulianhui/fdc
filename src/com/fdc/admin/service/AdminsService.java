package com.fdc.admin.service;

import java.util.List;

import com.fdc.admin.dao.AdminsDAO;
import com.fdc.admin.pojo.Admins;

public class AdminsService {
	private AdminsDAO adminsDAO;

	public AdminsDAO getAdminsDAO() {
		return adminsDAO;
	}

	public void setAdminsDAO(AdminsDAO adminsDAO) {
		this.adminsDAO = adminsDAO;
	}

	public boolean login(String userName, String password) {
		boolean result;
		if (userName == null || password == null) {
			result = false;
		}
		else {
			List<Admins> list = adminsDAO.findByUserName(userName);
			if (list.size() == 0) {
				result = false;
			}
			else if (!list.get(0).getPassword().equals(password)) {
				result = false;
			}
			else {
				result = true;
			}
		}
		return result;
	}

	public boolean login(Admins admins) {
		//adminsDAO.save(admins);
		return login(admins.getUserName(), admins.getPassword());
	}
}
