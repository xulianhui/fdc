package com.fdc.pojo;

import java.security.PublicKey;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nickName;
	private String realName;
	private String password;
	private String tel;
	private String email;
	private Boolean checked;
	private Boolean type;
	private Boolean sex;
	private Integer age;
	private String icNumber;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String nickName, String realName, String password, String tel,
			String email, Boolean checked, Boolean type) {
		this.nickName = nickName;
		this.realName = realName;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.checked = checked;
		this.type = type;
	}

	/** full constructor */
	public Users(String nickName, String realName, String password, String tel,
			String email, Boolean checked, Boolean type, Boolean sex,
			Integer age, String icNumber) {
		this.nickName = nickName;
		this.realName = realName;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.checked = checked;
		this.type = type;
		this.sex = sex;
		this.age = age;
		this.icNumber = icNumber;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getChecked() {
		return this.checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Boolean getType() {
		return this.type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Boolean getSex() {
		return this.sex;
	}
	
	public String getSexString() {
		if (this.sex == true) return "ÄÐ";
		else return "Å®";
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIcNumber() {
		return this.icNumber;
	}

	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}

}