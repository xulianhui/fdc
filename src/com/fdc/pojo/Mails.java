package com.fdc.pojo;

import java.sql.Timestamp;

/**
 * Mails entity. @author MyEclipse Persistence Tools
 */

public class Mails implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userFromId;
	private Integer userToId;
	private String title;
	private String mailContent;
	private Timestamp sendTime;
	private Boolean readFlag;

	// Constructors

	/** default constructor */
	public Mails() {
	}

	/** full constructor */
	public Mails(Integer userFromId, Integer userToId, String title,
			String mailContent, Timestamp sendTime, Boolean readFlag) {
		this.userFromId = userFromId;
		this.userToId = userToId;
		this.title = title;
		this.mailContent = mailContent;
		this.sendTime = sendTime;
		this.readFlag = readFlag;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserFromId() {
		return this.userFromId;
	}

	public void setUserFromId(Integer userFromId) {
		this.userFromId = userFromId;
	}

	public Integer getUserToId() {
		return this.userToId;
	}

	public void setUserToId(Integer userToId) {
		this.userToId = userToId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMailContent() {
		return this.mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Boolean getReadFlag() {
		return this.readFlag;
	}

	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
	}

}