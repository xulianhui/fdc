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

	ArrayList<HouseNewsRecord> houseNewsRecords;// 我租购的房屋记录
	ArrayList<Mails> mails;// 我的邮件列表
	ArrayList<HouseNews> myHouseNews;// 我发布的租售房信息
	ArrayList<HouseNewsRecord> myHouseNewsRecords;// 我的租售房屋记录

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

	public void setMyHouseNewsRecords(
			ArrayList<HouseNewsRecord> myHouseNewsRecords) {
		this.myHouseNewsRecords = myHouseNewsRecords;
	}
	/*
	.'"'.        ___,,,___        .'``.'
	: (\  `."'"```         ```"'"-'  /) ;'
	 :  \                         `./  .''
	 `.                            :.''
	   /        _         _        \)
	  |         0}       {0         |
	  |         /         \         |
	  |        /           \        |
	  |       /             \       |
	   \     |      .-.      |     /
	    `.   | . . /   \ . . |   .''
	      `-._\.'.(     ).'./_.-''
	          `\'  `._.'  '/' 
	            `. --'-- .'
	             `-...-''
	*/
	public String loadPageInfo()    {
		houseNewsRecords = new ArrayList<HouseNewsRecord>();
		myHouseNewsRecords = new ArrayList<HouseNewsRecord>();
		Users thisUsers = usersService.getUserById(1);
		/*
		 * 用户部分先模拟实现，后面通过session查找。
		 */
		if (thisUsers == null) {
			msg = "thisUsers pointer null error";
			return "error";
		}
		
		//用户的租购记录
		List recordList = recordRentService
				.getRecordListByHouseUserId(thisUsers.getId());
		for (int i = 0; i < recordList.size(); ++i) {
			RecordRent recordRent = (RecordRent) recordList.get(i);
			HouseNews houseNews = (HouseNews) houseNewsService.getHouseNewsById(recordRent.getHouseNewsId());
			houseNewsRecords.add(HouseNewsRecord.setHouseNewsRecord(recordRent, houseNews));
		}
		System.out.println("houseNewsRecords.size: " + houseNewsRecords.size());

		mails = (ArrayList<Mails>) mailsService
				.getMailsByUserToIdList(thisUsers.getId());

		myHouseNews = (ArrayList<HouseNews>) houseNewsService
				.getHouseNewsByUserId(thisUsers.getId());
		
		List<HouseNews> houseNewsList = houseNewsService.getHouseNewsByUserId(thisUsers.getId());
		System.out.println("houseNewsList.size: " + houseNewsList.size());
		for (HouseNews houseNews : houseNewsList) {
			List<RecordRent> recordRentList = recordRentService.getRecordListByHouseNewsId(houseNews.getId());
			System.out.println("recordList.size: " + recordList.size());
			if (recordRentList == null) {
				System.out.println("--------------------------------------------------------------> NullPointerException");
			} else {
				for (RecordRent recordRent : recordRentList) {
					if (recordRent == null) {
						System.out.print("recordRent Error\n");
					}
					if (houseNews == null) {
						System.out.print("houseNews Error\n");
					}
					myHouseNewsRecords.add(HouseNewsRecord.setHouseNewsRecord(recordRent, houseNews));
				}
			}
		}
		

		return "success";
	}
}





















