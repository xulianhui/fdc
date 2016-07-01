package com.fdc.service;

import java.util.List;

import com.fdc.dao.MailsDAO;

public class MailsService {
	MailsDAO mailsDAO;

	public MailsDAO getMailsDAO() {
		return mailsDAO;
	}

	public void setMailsDAO(MailsDAO mailsDAO) {
		this.mailsDAO = mailsDAO;
	}
	
	public List getMailsByUserToIdList (int id) {
		System.out.println("getMailsByUserToIdList id: " + id);
		return mailsDAO.findByUserToId(id);
	}
}
