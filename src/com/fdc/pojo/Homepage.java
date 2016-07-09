package com.fdc.pojo;

/**
 * Homepage entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Homepage implements java.io.Serializable {

	// Fields

	private Integer id;
	private String divname;
	private String picadd;
	private String remarks;

	// Constructors

	/** default constructor */
	public Homepage() {
	}

	/** full constructor */
	public Homepage(String divname, String picadd, String remarks) {
		this.divname = divname;
		this.picadd = picadd;
		this.remarks = remarks;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDivname() {
		return this.divname;
	}

	public void setDivname(String divname) {
		this.divname = divname;
	}

	public String getPicadd() {
		return this.picadd;
	}

	public void setPicadd(String picadd) {
		this.picadd = picadd;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}