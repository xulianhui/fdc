package com.fdc.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fdc.pojo.HouseNews;
import com.fdc.pojo.RecordRent;
import com.fdc.pojo.Users;
import com.fdc.service.HouseNewsService;
import com.fdc.service.RecordRentService;
import com.fdc.service.UsersService;
import com.opensymphony.xwork2.ActionContext;

public class SpaceActoin {
	UsersService usersService;
	HouseNewsService houseNewsService;
	RecordRentService recordRentService;

	File headImg;
	String headImgFileName;
	String headImgContentType;
	Users users;
	String oldPass;
	String passRe;
	String msg;
	int recordId;
	
	public RecordRentService getRecordRentService() {
		return recordRentService;
	}

	public void setRecordRentService(RecordRentService recordRentService) {
		this.recordRentService = recordRentService;
	}
	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}

	public HouseNewsService getHouseNewsService() {
		return houseNewsService;
	}

	public void setHouseNewsService(HouseNewsService houseNewsService) {
		this.houseNewsService = houseNewsService;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
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

	public String updateUserInfo() throws IOException {
		//
		// System.out.println(users.getNickName());
		// System.out.println(users.getRealName());
		// System.out.println(users.getPassword());
		// System.out.println(users.getAge());
		// System.out.println(users.getIcNumber());
		// System.out.println(users.getEmail());
		// System.out.println(users.getTel());
		//
		Users thisUsers = new Users();
		int userid = ((Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user")).getId();
		thisUsers = usersService.getUserById(userid);
		// System.out.print("userId: " + userid);

		if (oldPass == null || oldPass.equals(thisUsers.getPassword()) == false) {
			msg = "ԭ�������";
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
		if (getHeadImg() != null) {
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/upload");
			File savefile = new File(new File(realpath),
					System.currentTimeMillis() + thisUsers.getId()
							+ headImgFileName);
			System.out.println(savefile.getPath());
			if (!savefile.getParentFile().exists()) {
				savefile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(headImg, savefile);
			ActionContext.getContext().put("message", "�ļ��ϴ��ɹ�");
			thisUsers.setHeadImg("upload"
					+ savefile.getPath().replace(realpath, "")
							.replace("\\", "/"));
			msg = savefile.getPath().replace(realpath, "");
		}
		usersService.UpdateUserInfo(thisUsers);
		System.out.print("�û���Ϣ�޸ĳɹ�");
		return "success";
	}

	public String shelves() {
		houseNewsService.shelvesHouseById(houseNewsId);
		return "success";
	}
	
	public String agreeTran() {
		RecordRent recordRent = recordRentService.getRecordRentById(recordId);
		HouseNews houseNews = houseNewsService.getHouseNewsById(recordRent.getHouseNewsId());
		System.err.println("recordRent & houseNews 获取成功 " + houseNews.getId());
		
		if(houseNews.getHouseNewsStatus() == 1) {

			System.err.println("进入订单状态修改");
			recordRentService.agree(recordId);
			System.out.println(recordId + " 同意购买状态修改成功");
			
			System.err.println("进入房屋状态修改");
			houseNews.setHouseNewsStatus(2);
			houseNewsService.update(houseNews);
			System.out.println("房屋状态修改成功。");
			return "success";
		} else {
			msg="房屋状态错误";
			return "error";
		}
	}
	public String refuseTran() {
		System.out.println("进入拒绝交易 id= " + recordId);
		recordRentService.refuse(recordId);
		System.out.println("拒绝交易成功");
		return "success";
	}
	
	public String cancle() {
		System.out.println("进入取消 id = " + recordId);
		recordRentService.cancle(recordId);
		System.out.println("取消交易成功");
		return "success";
	}
	
}
