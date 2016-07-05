package com.fdc.action;


import java.io.File;

import org.apache.commons.validator.Msg;

import com.fdc.pojo.Users;
import com.fdc.service.HouseNewsService;
import com.fdc.service.UsersService;
import com.opensymphony.xwork2.ActionContext;

public class SpaceActoin{
	UsersService usersService;
	HouseNewsService houseNewsService;
	
	File headImgFile;
	Users users;
	String oldPass;
	String passRe;
	String msg;
	public HouseNewsService getHouseNewsService() {
		return houseNewsService;
	}
	public void setHouseNewsService(HouseNewsService houseNewsService) {
		this.houseNewsService = houseNewsService;
	}

	public File getHeadImgFile() {
		return headImgFile;
	}
	public void setHeadImgFile(File headImgFile) {
		this.headImgFile = headImgFile;
	}
	public String getPassRe() {
		return passRe;
	}
	public void setPassRe(String passre) {
		this.passRe = passre;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	int houseNewsId;
	public int getHouseNewsId() {
		return houseNewsId;
	}
	public void setHouseNewsId(int houseNewsId) {
		this.houseNewsId = houseNewsId;
	}
	public UsersService getUsersService() {
		return usersService;
	}
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public String updateUserInfo() {
//		
//		System.out.println(users.getNickName());
//		System.out.println(users.getRealName());
//		System.out.println(users.getPassword());
//		System.out.println(users.getAge());
//		System.out.println(users.getIcNumber());
//		System.out.println(users.getEmail());
//		System.out.println(users.getTel());
//		
		Users thisUsers = new Users();
		int userid = (int) ActionContext.getContext().getSession().get("userid");
		thisUsers = usersService.getUserById(userid);
//		System.out.print("userId: " + userid);
		
		if (oldPass == null || oldPass.equals(thisUsers.getPassword()) == false) {
			msg = "原密码错误";
			return "error";
		}
		
		
		if (users.getNickName().equals("") == false) {
			thisUsers.setNickName(users.getNickName());
		}
		if (users.getRealName().equals("") == false) {
			thisUsers.setRealName(users.getRealName());
		}
		if (users.getPassword().equals("") == false) {
			thisUsers.setPassword(users.getPassword());
		}
		if (users.getAge() != null) {
			thisUsers.setAge(users.getAge());
		}
		if (users.getIcNumber().equals("") == false) {
			thisUsers.setIcNumber(users.getIcNumber());
		}
		if (users.getEmail().equals("") == false) {
			thisUsers.setEmail(users.getEmail());
		}
		if (users.getTel().equals("") == false) {
			thisUsers.setTel(users.getTel());
		}
		if (getHeadImgFile() != null) {
			msg="头像上传";
			return "error";
		}
		usersService.UpdateUserInfo(thisUsers);
		System.out.print("用户信息修改成功");
		return "success";
	}
	
	public String shelves() {
		houseNewsService.shelvesHouseById(houseNewsId);
		return "success";
	}
}
