package com.fdc.pojo;

/**
 * Collections entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Collections implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer houseNewsId;

	// Constructors

	/** default constructor */
	public Collections() {
	}

	/** full constructor */
	public Collections(Integer userId, Integer houseNewsId) {
		this.userId = userId;
		this.houseNewsId = houseNewsId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHouseNewsId() {
		return this.houseNewsId;
	}

	public void setHouseNewsId(Integer houseNewsId) {
		this.houseNewsId = houseNewsId;
	}

}