package com.fdc.admin.pojo;

import java.sql.Timestamp;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */

public class Comments implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer comterId;
	private Integer comtedId;
	private String content;
	private Timestamp conTime;

	// Constructors

	/** default constructor */
	public Comments() {}

	/** full constructor */
	public Comments(Integer comterId, Integer comtedId, String content,
			Timestamp conTime) {
		this.comterId = comterId;
		this.comtedId = comtedId;
		this.content = content;
		this.conTime = conTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getComterId() {
		return this.comterId;
	}

	public void setComterId(Integer comterId) {
		this.comterId = comterId;
	}

	public Integer getComtedId() {
		return this.comtedId;
	}

	public void setComtedId(Integer comtedId) {
		this.comtedId = comtedId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getConTime() {
		return this.conTime;
	}

	public void setConTime(Timestamp conTime) {
		this.conTime = conTime;
	}

}