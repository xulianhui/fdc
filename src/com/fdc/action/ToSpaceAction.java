package com.fdc.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fdc.po.HouseNewsRecord;
import com.fdc.pojo.Collections;
import com.fdc.pojo.HouseNews;
import com.fdc.pojo.Mails;
import com.fdc.pojo.RecordRent;
import com.fdc.pojo.Users;
import com.fdc.service.CollectService;
import com.fdc.service.HouseNewsService;
import com.fdc.service.MailsService;
import com.fdc.service.RecordRentService;
import com.fdc.service.UsersService;

public class ToSpaceAction {
	String msg;

	UsersService usersService;
	RecordRentService recordRentService;
	HouseNewsService houseNewsService;
	MailsService mailsService;
	CollectService collectService;

	Users thisUsers;// ��ǰ�û�
	ArrayList<HouseNewsRecord> houseNewsRecords;// ���⹺�ķ��ݼ�¼
	ArrayList<Mails> mails;// �ҵ��ʼ��б�
	ArrayList<HouseNews> myHouseNews;// �ҷ��������۷���Ϣ
	ArrayList<HouseNewsRecord> myHouseNewsRecords;// �ҵ����۷��ݼ�¼
	ArrayList<HouseNews> collectHouses;

	public ArrayList<HouseNews> getCollectHouses() {
		return collectHouses;
	}

	public void setCollectHouses(ArrayList<HouseNews> collectHouses) {
		this.collectHouses = collectHouses;
	}

	public CollectService getCollectService() {
		return collectService;
	}

	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}

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

	public Users getThisUsers() {
		return thisUsers;
	}

	public void setThisUsers(Users thisUsers) {
		this.thisUsers = thisUsers;
	}

	public void setMyHouseNewsRecords(
			ArrayList<HouseNewsRecord> myHouseNewsRecords) {
		this.myHouseNewsRecords = myHouseNewsRecords;
	}

	/*
	 * .'"'. ___,,,___ .'``.' : (\ `."'"``` ```"'"-' /) ;' : \ `./ .'' `. :.'' /
	 * _ _ \) | 0} {0 | | / \ | | / \ | | / \ | \ | .-. | / `. | . . / \ . . |
	 * .'' `-._\.'.( ).'./_.-'' `\' `._.' '/' `. --'-- .' `-...-''
	 */
	@SuppressWarnings("unchecked")
	public String loadPageInfo() {
		houseNewsRecords = new ArrayList<HouseNewsRecord>();
		myHouseNewsRecords = new ArrayList<HouseNewsRecord>();
		thisUsers = new Users();

		//
		if (((Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user")) == null) {
			msg = "请重新登录！";
			return "error";
		}
		int userid = ((Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user")).getId();
		thisUsers = usersService.getUserById(userid);
		if (thisUsers == null) {
			msg = "Please sign in first!";
			return "error";
		}

		List<?> recordList = recordRentService
				.getRecordListByHouseUserId(thisUsers.getId());
		for (int i = 0; i < recordList.size(); ++i) {
			RecordRent recordRent = (RecordRent) recordList.get(i);
			HouseNews houseNews = (HouseNews) houseNewsService
					.getHouseNewsById(recordRent.getHouseNewsId());
			houseNewsRecords.add(HouseNewsRecord.setHouseNewsRecord(recordRent,
					houseNews));
		}
		System.out.println("houseNewsRecords.size: " + houseNewsRecords.size());

		// �û���Ϣ
		mails = (ArrayList<Mails>) mailsService
				.getMailsByUserToIdList(thisUsers.getId());

		// �û������ķ���
		myHouseNews = (ArrayList<HouseNews>) houseNewsService
				.getHouseNewsByUserId(thisUsers.getId());

		// �û��յ��Ķ���
		List<HouseNews> houseNewsList = houseNewsService
				.getHouseNewsByUserId(thisUsers.getId());

		System.out.println("thisUsers.getId: " + thisUsers.getId());
		System.out.println("houseNewsList.size: " + houseNewsList.size());
		for (HouseNews houseNews : houseNewsList) {
			List<RecordRent> recordRentList = recordRentService
					.getRecordListByHouseNewsId(houseNews.getId());
			System.out.println("recordList.size: " + recordList.size());
			if (recordRentList == null) {
				System.out
						.println("--------------------------------------------------------------> NullPointerException");
			} else {
				for (RecordRent recordRent : recordRentList) {
					if (recordRent == null) {
						System.out.print("recordRent Error\n");
					}
					if (houseNews == null) {
						System.out.print("houseNews Error\n");
					}
					myHouseNewsRecords.add(HouseNewsRecord.setHouseNewsRecord(
							recordRent, houseNews));
				}
			}
		}

		// collectHouses collectService.findHouseNews(userid);

		List<?> collectsList = collectService.findHouseNews(userid);
		collectHouses = new ArrayList<HouseNews>();
		for (Object e : collectsList) {
			Collections collections = (Collections) e;
			HouseNews tmpHouseNews = houseNewsService
					.getHouseNewsById(collections.getHouseNewsId());
			collectHouses.add(tmpHouseNews);
		}

		return "success";
	}
}
