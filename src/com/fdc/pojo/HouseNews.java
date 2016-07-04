package com.fdc.pojo;

/**
 * HouseNews entity. @author MyEclipse Persistence Tools
 */

public class HouseNews implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer newsType;
	private String houseReg;
	private String houseAddDetail;
	private String houseTitle;
	private Integer houseFloor;
	private Integer housePrice;
	private Integer houseHall;
	private Integer houseWc;
	private Integer houseRoom;
	private Integer houseArea;
	private String buildType;
	private String houseDetail;
	private String tel;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	private String img6;
	private Integer houseNewsStatus;

	// Constructors

	/** default constructor */
	public HouseNews() {
	}

	/** minimal constructor */
	public HouseNews(Integer userId, Integer newsType, String houseReg,
			String houseAddDetail, String houseTitle, Integer houseFloor,
			Integer housePrice, Integer houseHall, Integer houseWc,
			Integer houseRoom, Integer houseArea, String buildType, String tel,
			Integer houseNewsStatus) {
		this.userId = userId;
		this.newsType = newsType;
		this.houseReg = houseReg;
		this.houseAddDetail = houseAddDetail;
		this.houseTitle = houseTitle;
		this.houseFloor = houseFloor;
		this.housePrice = housePrice;
		this.houseHall = houseHall;
		this.houseWc = houseWc;
		this.houseRoom = houseRoom;
		this.houseArea = houseArea;
		this.buildType = buildType;
		this.tel = tel;
		this.houseNewsStatus = houseNewsStatus;
	}

	/** full constructor */
	public HouseNews(Integer userId, Integer newsType, String houseReg,
			String houseAddDetail, String houseTitle, Integer houseFloor,
			Integer housePrice, Integer houseHall, Integer houseWc,
			Integer houseRoom, Integer houseArea, String buildType,
			String houseDetail, String tel, String img1, String img2,
			String img3, String img4, String img5, String img6,
			Integer houseNewsStatus) {
		this.userId = userId;
		this.newsType = newsType;
		this.houseReg = houseReg;
		this.houseAddDetail = houseAddDetail;
		this.houseTitle = houseTitle;
		this.houseFloor = houseFloor;
		this.housePrice = housePrice;
		this.houseHall = houseHall;
		this.houseWc = houseWc;
		this.houseRoom = houseRoom;
		this.houseArea = houseArea;
		this.buildType = buildType;
		this.houseDetail = houseDetail;
		this.tel = tel;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.houseNewsStatus = houseNewsStatus;
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

	public Integer getNewsType() {
		return this.newsType;
	}

	public void setNewsType(Integer newsType) {
		this.newsType = newsType;
	}

	public String getHouseReg() {
		return this.houseReg;
	}

	public void setHouseReg(String houseReg) {
		this.houseReg = houseReg;
	}

	public String getHouseAddDetail() {
		return this.houseAddDetail;
	}

	public void setHouseAddDetail(String houseAddDetail) {
		this.houseAddDetail = houseAddDetail;
	}

	public String getHouseTitle() {
		return this.houseTitle;
	}

	public void setHouseTitle(String houseTitle) {
		this.houseTitle = houseTitle;
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

	public Integer getHouseHall() {
		return this.houseHall;
	}

	public void setHouseHall(Integer houseHall) {
		this.houseHall = houseHall;
	}

	public Integer getHouseWc() {
		return this.houseWc;
	}

	public void setHouseWc(Integer houseWc) {
		this.houseWc = houseWc;
	}

	public Integer getHouseRoom() {
		return this.houseRoom;
	}

	public void setHouseRoom(Integer houseRoom) {
		this.houseRoom = houseRoom;
	}

	public Integer getHouseArea() {
		return this.houseArea;
	}

	public void setHouseArea(Integer houseArea) {
		this.houseArea = houseArea;
	}

	public String getBuildType() {
		return this.buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public String getHouseDetail() {
		return this.houseDetail;
	}

	public void setHouseDetail(String houseDetail) {
		this.houseDetail = houseDetail;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getImg1() {
		return this.img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return this.img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return this.img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return this.img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public String getImg5() {
		return this.img5;
	}

	public void setImg5(String img5) {
		this.img5 = img5;
	}

	public String getImg6() {
		return this.img6;
	}

	public void setImg6(String img6) {
		this.img6 = img6;
	}

	public Integer getHouseNewsStatus() {
		return this.houseNewsStatus;
	}

	public void setHouseNewsStatus(Integer houseNewsStatus) {
		this.houseNewsStatus = houseNewsStatus;
	}

}