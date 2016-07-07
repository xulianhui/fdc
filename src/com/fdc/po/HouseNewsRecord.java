package com.fdc.po;

import com.fdc.pojo.HouseNews;
import com.fdc.pojo.RecordRent;

public class HouseNewsRecord {
	private String houseAddr;
	private Integer houseFloor;
	private Integer housePrice;
	private String houseTitle;
	private Integer houseArea;
	private String houseStatus;
	private String tel;
	private Integer newsType;
	private String photo;
	private Integer houseNewsId;
	private Integer houseUserId;

	private Integer recordState;
	private String recordReqTime;
	private Boolean recordType;
	private Integer recordId;
	private Integer id;

	// Constructors

	/** default constructor */
	public HouseNewsRecord() {
	}

	/** minimal constructor */
	public HouseNewsRecord(String houseAddr, Integer houseFloor,
			Integer housePrice, String houseTitle, Integer houseArea,
			String houseStatus, String tel, Integer newsType,
			Integer houseNewsId, Integer houseUserId, Integer recordState,
			String recordReqTime, Boolean recordType, Integer recordId,
			Integer id) {
		this.houseAddr = houseAddr;
		this.houseFloor = houseFloor;
		this.housePrice = housePrice;
		this.houseTitle = houseTitle;
		this.houseArea = houseArea;
		this.houseStatus = houseStatus;
		this.tel = tel;
		this.newsType = newsType;
		this.houseNewsId = houseNewsId;
		this.houseUserId = houseUserId;
		this.recordState = recordState;
		this.recordReqTime = recordReqTime;
		this.recordType = recordType;
		this.recordId = recordId;
		this.id = id;
	}

	/** full constructor */
	public HouseNewsRecord(String houseAddr, Integer houseFloor,
			Integer housePrice, String houseTitle, Integer houseArea,
			String houseStatus, String tel, Integer newsType, String photo,
			Integer houseNewsId, Integer houseUserId, Integer recordState,
			String recordReqTime, Boolean recordType, Integer recordId,
			Integer id) {
		this.houseAddr = houseAddr;
		this.houseFloor = houseFloor;
		this.housePrice = housePrice;
		this.houseTitle = houseTitle;
		this.houseArea = houseArea;
		this.houseStatus = houseStatus;
		this.tel = tel;
		this.newsType = newsType;
		this.photo = photo;
		this.houseNewsId = houseNewsId;
		this.houseUserId = houseUserId;
		this.recordState = recordState;
		this.recordReqTime = recordReqTime;
		this.recordType = recordType;
		this.recordId = recordId;
		this.id = id;
	}

	// Property accessors

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

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getHouseNewsId() {
		return this.houseNewsId;
	}

	public void setHouseNewsId(Integer houseNewsId) {
		this.houseNewsId = houseNewsId;
	}

	public Integer getHouseUserId() {
		return this.houseUserId;
	}

	public void setHouseUserId(Integer houseUserId) {
		this.houseUserId = houseUserId;
	}

	public Integer getRecordState() {
		return this.recordState;
	}

	public void setRecordState(Integer recordState) {
		this.recordState = recordState;
	}

	public String getRecordReqTime() {
		return this.recordReqTime;
	}

	public void setRecordReqTime(String recordReqTime) {
		this.recordReqTime = recordReqTime;
	}

	public Boolean getRecordType() {
		return this.recordType;
	}

	public void setRecordType(Boolean recordType) {
		this.recordType = recordType;
	}

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HouseNewsRecord))
			return false;
		HouseNewsRecord castOther = (HouseNewsRecord) other;

		return ((this.getHouseAddr() == castOther.getHouseAddr()) || (this
				.getHouseAddr() != null && castOther.getHouseAddr() != null && this
				.getHouseAddr().equals(castOther.getHouseAddr())))
				&& ((this.getHouseFloor() == castOther.getHouseFloor()) || (this
						.getHouseFloor() != null
						&& castOther.getHouseFloor() != null && this
						.getHouseFloor().equals(castOther.getHouseFloor())))
				&& ((this.getHousePrice() == castOther.getHousePrice()) || (this
						.getHousePrice() != null
						&& castOther.getHousePrice() != null && this
						.getHousePrice().equals(castOther.getHousePrice())))
				&& ((this.getHouseTitle() == castOther.getHouseTitle()) || (this
						.getHouseTitle() != null
						&& castOther.getHouseTitle() != null && this
						.getHouseTitle().equals(castOther.getHouseTitle())))
				&& ((this.getHouseArea() == castOther.getHouseArea()) || (this
						.getHouseArea() != null
						&& castOther.getHouseArea() != null && this
						.getHouseArea().equals(castOther.getHouseArea())))
				&& ((this.getHouseStatus() == castOther.getHouseStatus()) || (this
						.getHouseStatus() != null
						&& castOther.getHouseStatus() != null && this
						.getHouseStatus().equals(castOther.getHouseStatus())))
				&& ((this.getTel() == castOther.getTel()) || (this.getTel() != null
						&& castOther.getTel() != null && this.getTel().equals(
						castOther.getTel())))
				&& ((this.getNewsType() == castOther.getNewsType()) || (this
						.getNewsType() != null
						&& castOther.getNewsType() != null && this
						.getNewsType().equals(castOther.getNewsType())))
				&& ((this.getPhoto() == castOther.getPhoto()) || (this
						.getPhoto() != null && castOther.getPhoto() != null && this
						.getPhoto().equals(castOther.getPhoto())))
				&& ((this.getHouseNewsId() == castOther.getHouseNewsId()) || (this
						.getHouseNewsId() != null
						&& castOther.getHouseNewsId() != null && this
						.getHouseNewsId().equals(castOther.getHouseNewsId())))
				&& ((this.getHouseUserId() == castOther.getHouseUserId()) || (this
						.getHouseUserId() != null
						&& castOther.getHouseUserId() != null && this
						.getHouseUserId().equals(castOther.getHouseUserId())))
				&& ((this.getRecordState() == castOther.getRecordState()) || (this
						.getRecordState() != null
						&& castOther.getRecordState() != null && this
						.getRecordState().equals(castOther.getRecordState())))
				&& ((this.getRecordReqTime() == castOther.getRecordReqTime()) || (this
						.getRecordReqTime() != null
						&& castOther.getRecordReqTime() != null && this
						.getRecordReqTime()
						.equals(castOther.getRecordReqTime())))
				&& ((this.getRecordType() == castOther.getRecordType()) || (this
						.getRecordType() != null
						&& castOther.getRecordType() != null && this
						.getRecordType().equals(castOther.getRecordType())))
				&& ((this.getRecordId() == castOther.getRecordId()) || (this
						.getRecordId() != null
						&& castOther.getRecordId() != null && this
						.getRecordId().equals(castOther.getRecordId())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHouseAddr() == null ? 0 : this.getHouseAddr().hashCode());
		result = 37
				* result
				+ (getHouseFloor() == null ? 0 : this.getHouseFloor()
						.hashCode());
		result = 37
				* result
				+ (getHousePrice() == null ? 0 : this.getHousePrice()
						.hashCode());
		result = 37
				* result
				+ (getHouseTitle() == null ? 0 : this.getHouseTitle()
						.hashCode());
		result = 37 * result
				+ (getHouseArea() == null ? 0 : this.getHouseArea().hashCode());
		result = 37
				* result
				+ (getHouseStatus() == null ? 0 : this.getHouseStatus()
						.hashCode());
		result = 37 * result
				+ (getTel() == null ? 0 : this.getTel().hashCode());
		result = 37 * result
				+ (getNewsType() == null ? 0 : this.getNewsType().hashCode());
		result = 37 * result
				+ (getPhoto() == null ? 0 : this.getPhoto().hashCode());
		result = 37
				* result
				+ (getHouseNewsId() == null ? 0 : this.getHouseNewsId()
						.hashCode());
		result = 37
				* result
				+ (getHouseUserId() == null ? 0 : this.getHouseUserId()
						.hashCode());
		result = 37
				* result
				+ (getRecordState() == null ? 0 : this.getRecordState()
						.hashCode());
		result = 37
				* result
				+ (getRecordReqTime() == null ? 0 : this.getRecordReqTime()
						.hashCode());
		result = 37
				* result
				+ (getRecordType() == null ? 0 : this.getRecordType()
						.hashCode());
		result = 37 * result
				+ (getRecordId() == null ? 0 : this.getRecordId().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		return result;
	}

	public static HouseNewsRecord setHouseNewsRecord(RecordRent recordRent,
			HouseNews houseNews) {
		HouseNewsRecord tmp = new HouseNewsRecord();

		tmp.setId(houseNews.getId());
		tmp.setHouseAddr(houseNews.getHouseAddDetail());
		tmp.setHouseFloor(houseNews.getHouseFloor());
		tmp.setHousePrice(houseNews.getHousePrice());
		tmp.setHouseTitle(houseNews.getHouseTitle());
		tmp.setHouseArea(houseNews.getHouseArea());
		tmp.setHouseStatus(houseNews.getBuildType());
		tmp.setTel(houseNews.getTel());
		tmp.setNewsType(houseNews.getNewsType());
		// photo
		tmp.setHouseNewsId(recordRent.getHouseNewsId());
		tmp.setHouseUserId(recordRent.getHouseNewsId());
		tmp.setRecordState(recordRent.getRecordState());
		tmp.setRecordReqTime(recordRent.getRecordReqTime());
		tmp.setRecordType(recordRent.getRecordType());
		tmp.setRecordId(recordRent.getRecordId());

		return tmp;
	}
}
