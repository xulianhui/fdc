package com.fdc.action;

import java.util.List;

import org.hibernate.engine.query.ReturnMetadata;

import com.fdc.pojo.Users;
import com.fdc.service.RecordRentService;
import com.fdc.service.UsersService;

public class ToSpaceAction {
	UsersService usersService;
	RecordRentService recordRentService;
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
	
	
	public String loadPageInfo () {
		
		Users thisUsers = usersService.getUserById(1);
		List recordList = recordRentService.getRecordListByHouseUserId(thisUsers.getId());
		
		for (int i=0; i<recordList.size(); ++i) {
			
		}
		
		return "success";
	}
}
