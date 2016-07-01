package com.fdc.pojo;

/**
 * RecordRent entity. @author MyEclipse Persistence Tools
 */

public class RecordRent implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private Integer houseNewsId;
	private Integer houseUserId;
	private Integer recordState;
	private String recordReqTime;
	private Boolean recordType;

	// Constructors

	/** default constructor */
	public RecordRent() {
	}

	/** full constructor */
	public RecordRent(Integer houseNewsId, Integer houseUserId,
			Integer recordState, String recordReqTime, Boolean recordType) {
		this.houseNewsId = houseNewsId;
		this.houseUserId = houseUserId;
		this.recordState = recordState;
		this.recordReqTime = recordReqTime;
		this.recordType = recordType;
	}

	// Property accessors

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
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

}