package com.fdc.pojo;

/**
 * Wanted entity. @author MyEclipse Persistence Tools
 */

public class Wanted implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String userTel;
	private Integer maxPrice;
	private Integer minArea;
	private Integer maxArea;
	private Boolean wantedType;
	private String details;

	// Constructors

	/** default constructor */
	public Wanted() {
	}

	/** full constructor */
	public Wanted(Integer userId, String userTel, Integer maxPrice,
			Integer minArea, Integer maxArea, Boolean wantedType, String details) {
		this.userId = userId;
		this.userTel = userTel;
		this.maxPrice = maxPrice;
		this.minArea = minArea;
		this.maxArea = maxArea;
		this.wantedType = wantedType;
		this.details = details;
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

	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public Integer getMaxPrice() {
		return this.maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Integer getMinArea() {
		return this.minArea;
	}

	public void setMinArea(Integer minArea) {
		this.minArea = minArea;
	}

	public Integer getMaxArea() {
		return this.maxArea;
	}

	public void setMaxArea(Integer maxArea) {
		this.maxArea = maxArea;
	}

	public Boolean getWantedType() {
		return this.wantedType;
	}

	public void setWantedType(Boolean wantedType) {
		this.wantedType = wantedType;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}