package com.fdc.service;

import java.util.List;

import com.fdc.dao.MailsDAO;
import com.fdc.pojo.Mails;

public class MailsService {
	MailsDAO mailsDAO;
	private int toId;

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public MailsDAO getMailsDAO() {
		return mailsDAO;
	}

	public void setMailsDAO(MailsDAO mailsDAO) {
		this.mailsDAO = mailsDAO;
	}

	public List<Mails> getMailsByUserToIdList(int id) {
		return mailsDAO.findByUserToId(id);
	}

	public boolean sendMail(Mails mail) {
		if (mailsDAO.savenew(mail))
			return true;
		return false;
	}

	public String sendMessage() {

		return "success";
	}

}
