package com.fdc.pojo;

import java.sql.Timestamp;

/**
 * RecordRent entity. @author MyEclipse Persistence Tools
 */

public class RecordRent implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private Integer houseNewsId;
	private Integer houseUserId;
	private Integer recordState;
	private Boolean recordType;
	private Timestamp recordReqTime;

	// Constructors

	/** default constructor */
	public RecordRent() {
	}

	/** minimal constructor */
	public RecordRent(Integer houseNewsId, Integer houseUserId,
			Integer recordState, Boolean recordType) {
		this.houseNewsId = houseNewsId;
		this.houseUserId = houseUserId;
		this.recordState = recordState;
		this.recordType = recordType;
	}

	/** full constructor */
	public RecordRent(Integer houseNewsId, Integer houseUserId,
			Integer recordState, Boolean recordType, Timestamp recordReqTime) {
		this.houseNewsId = houseNewsId;
		this.houseUserId = houseUserId;
		this.recordState = recordState;
		this.recordType = recordType;
		this.recordReqTime = recordReqTime;
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

	public Boolean getRecordType() {
		return this.recordType;
	}

	public void setRecordType(Boolean recordType) {
		this.recordType = recordType;
	}

	public Timestamp getRecordReqTime() {
		return this.recordReqTime;
	}

	public void setRecordReqTime(Timestamp recordReqTime) {
		this.recordReqTime = recordReqTime;
	}

}