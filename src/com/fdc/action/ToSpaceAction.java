package com.fdc.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.query.ReturnMetadata;

import com.fdc.dao.MailsDAO;
import com.fdc.po.HouseNewsRecord;
import com.fdc.pojo.HouseNews;
import com.fdc.pojo.Mails;
import com.fdc.pojo.RecordRent;
import com.fdc.pojo.Users;
import com.fdc.service.HouseNewsService;
import com.fdc.service.MailsService;
import com.fdc.service.RecordRentService;
import com.fdc.service.UsersService;
import com.opensymphony.xwork2.ActionContext;

public class ToSpaceAction {
	String msg;
	
	UsersService usersService;
	RecordRentService recordRentService;
	HouseNewsService houseNewsService;
	MailsService mailsService;
	
	
	ArrayList<HouseNewsRecord> houseNewsRecords;//我租购的房屋记录
	ArrayList<Mails> mails;//我的邮件列表
	ArrayList<HouseNews> myHouseNews;//我发布的租售房信息
	ArrayList<HouseNewsRecord> myHouseNewsRecords;//我的租售房屋记录
	
	public ArrayList<HouseNewsRecord> getHouseNewsRecords() {
		return houseNewsRecords;
	}

	public void setHouseNewsRecords(ArrayList<HouseNewsRecord> houseNewsRecords) {
		this.houseNewsRecords = houseNewsRecords;
	}

	public HouseNewsService getHouseNewsService() {
		return houseNewsService;
	}

	public void setHouseNewsService(HouseNewsService houseNewsService) {
		this.houseNewsService = houseNewsService;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public RecordRentService getRecordRentService() {
		return recordRentService;
	}

	public void setRecordRentService(RecordRentService recordRentService) {
		this.recordRentService = recordRentService;
	}

	public MailsService getMailsService() {
		return mailsService;
	}

	public void setMailsService(MailsService mailsService) {
		this.mailsService = mailsService;
	}

	public ArrayList<Mails> getMails() {
		return mails;
	}

	public void setMails(ArrayList<Mails> mails) {
		this.mails = mails;
	}
	
	public ArrayList<HouseNews> getMyHouseNews() {
		return myHouseNews;
	}

	public void setMyHouseNews(ArrayList<HouseNews> myHouseNews) {
		this.myHouseNews = myHouseNews;
	}

	public ArrayList<HouseNewsRecord> getMyHouseNewsRecords() {
		return myHouseNewsRecords;
	}

	public void setMyHouseNewsRecords(ArrayList<HouseNewsRecord> myHouseNewsRecords) {
		this.myHouseNewsRecords = myHouseNewsRecords;
	}

// .'"'.        ___,,,___        .'``.'
// : (\  `."'"```         ```"'"-'  /) ;'
//  :  \                         `./  .''
//  `.                            :.''
//	 /        _         _        \)
//   |         0}       {0         |
//   |         /         \         |
//   |        /           \        |
//   |       /             \       |
//    \     |      .-.      |     /
// 	   `.   | . . /   \ . . |   .''
//	     `-._\.'.(     ).'./_.-''
//	        `\'  `._.'  '/' 
//             `. --'-- .'
//              `-...-'。'

	public String loadPageInfo() {
		houseNewsRecords = new ArrayList<HouseNewsRecord>();
		Users thisUsers = usersService.getUserById(1);
		/*
		 * 用户部分先模拟实现，后面通过session查找。
		 * */
		if (thisUsers == null) {
			msg = "thisUsers pointer null error";
			return "error";
		}
		List recordList = recordRentService
				.getRecordListByHouseUserId(thisUsers.getId());

		for (int i = 0; i < recordList.size(); ++i) {
			RecordRent recordRent = (RecordRent) recordList.get(i);
			System.out.println(recordRent.getRecordId() + " "
					+ recordRent.getHouseNewsId() + " "
					+ recordRent.getHouseUserId() + " "
					+ recordRent.getRecordReqTime());
			HouseNews houseNews = houseNewsService.getHouseNewsById(recordRent.getHouseNewsId());
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
//			photo
			tmp.setHouseNewsId(recordRent.getHouseNewsId());
			tmp.setHouseUserId(recordRent.getHouseNewsId());
			tmp.setRecordState(recordRent.getRecordState());
			tmp.setRecordReqTime(recordRent.getRecordReqTime());
			tmp.setRecordType(recordRent.getRecordType());
			tmp.setRecordId(recordRent.getRecordId());
			
			
			houseNewsRecords.add(tmp);
		}

		
		mails = (ArrayList<Mails>) mailsService.getMailsByUserToIdList(thisUsers.getId());
		return "success";
	}

}
