package com.fdc.action;

import java.sql.Timestamp;

import com.fdc.pojo.Mails;
import com.fdc.service.MailsService;

public class MailsAction {
	private Mails mail;
	private MailsService mailsService;

	public Mails getMail() {
		return mail;
	}

	public void setMail(Mails mail) {
		this.mail = mail;
	}

	public MailsService getMailsService() {
		return mailsService;
	}

	public void setMailsService(MailsService mailsService) {
		this.mailsService = mailsService;
	}

	public String execute() {
		java.util.Date date = new java.util.Date();
		Timestamp addtime = new Timestamp(date.getTime());
		mail.setSendTime(addtime);
		mail.setUserFromId(1 );
		if (mailsService.sendMail(mail))
			return "success";
		else
			return "error";
	}
}
