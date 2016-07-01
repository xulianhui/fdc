package com.fdc.pojo;

/**
 * HouseNews entity. @author MyEclipse Persistence Tools
 */

public class HouseNews implements java.io.Serializable {

	// Fields

	private Integer id;
	private String houseAddr;
	private Integer houseFloor;
	private Integer housePrice;
	private String houseTitle;
	private Integer houseArea;
	private String houseStatus;
	private String tel;
	private Integer newsType;
	private String houseStruct;
	private String houseLook;
	private String buildtype;
	private String buildtime;
	private String villagetype;
	private String special;
	private String photo;

	// Constructors

	/** default constructor */
	public HouseNews() {
	}

	/** minimal constructor */
	public HouseNews(String houseAddr, Integer houseFloor, Integer housePrice,
			String houseTitle, Integer houseArea, String houseStatus,
			String tel, Integer newsType) {
		this.houseAddr = houseAddr;
		this.houseFloor = houseFloor;
		this.housePrice = housePrice;
		this.houseTitle = houseTitle;
		this.houseArea = houseArea;
		this.houseStatus = houseStatus;
		this.tel = tel;
		this.newsType = newsType;
	}

	/** full constructor */
	public HouseNews(String houseAddr, Integer houseFloor, Integer housePrice,
			String houseTitle, Integer houseArea, String houseStatus,
			String tel, Integer newsType, String houseStruct, String houseLook,
			String buildtype, String buildtime, String villagetype,
			String special, String photo) {
		this.houseAddr = houseAddr;
		this.houseFloor = houseFloor;
		this.housePrice = housePrice;
		this.houseTitle = houseTitle;
		this.houseArea = houseArea;
		this.houseStatus = houseStatus;
		this.tel = tel;
		this.newsType = newsType;
		this.houseStruct = houseStruct;
		this.houseLook = houseLook;
		this.buildtype = buildtype;
		this.buildtime = buildtime;
		this.villagetype = villagetype;
		this.special = special;
		this.photo = photo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseAddr() {
		return this.houseAddr;
	}

	public void setHouseAddr(String houseAddr) {
		this.houseAddr = houseAddr;
	}

	public Integer getHouseFloor() {
		return this.houseFloor;
	}

	public void setHouseFloor(Integer houseFloor) {
		this.houseFloor = houseFloor;
	}

	public Integer getHousePrice() {
		return this.housePrice;
	}

	public void setHousePrice(Integer housePrice) {
		this.housePrice = housePrice;
	}

	public String getHouseTitle() {
		return this.houseTitle;
	}

	public void setHouseTitle(String houseTitle) {
		this.houseTitle = houseTitle;
	}

	public Integer getHouseArea() {
		return this.houseArea;
	}

	public void setHouseArea(Integer houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseStatus() {
		return this.houseStatus;
	}

	public void setHouseStatus(String houseStatus) {
		this.houseStatus = houseStatus;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getNewsType() {
		return this.newsType;
	}

	public void setNewsType(Integer newsType) {
		this.newsType = newsType;
	}

	public String getHouseStruct() {
		return this.houseStruct;
	}

	public void setHouseStruct(String houseStruct) {
		this.houseStruct = houseStruct;
	}

	public String getHouseLook() {
		return this.houseLook;
	}

	public void setHouseLook(String houseLook) {
		this.houseLook = houseLook;
	}

	public String getBuildtype() {
		return this.buildtype;
	}

	public void setBuildtype(String buildtype) {
		this.buildtype = buildtype;
	}

	public String getBuildtime() {
		return this.buildtime;
	}

	public void setBuildtime(String buildtime) {
		this.buildtime = buildtime;
	}

	public String getVillagetype() {
		return this.villagetype;
	}

	public void setVillagetype(String villagetype) {
		this.villagetype = villagetype;
	}

	public String getSpecial() {
		return this.special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}