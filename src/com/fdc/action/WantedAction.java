package com.fdc.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fdc.pojo.Users;
import com.fdc.pojo.Wanted;
import com.fdc.service.UsersService;
import com.fdc.service.WantedService;
import com.fdc.util.Pair;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class WantedAction implements Action {
	private WantedService wantedService;
	private UsersService usersService;
	private List<Wanted> wantedList;
	private Wanted wanted;
	private List<Pair<Wanted, Users>> WUList;

	public WantedService getWantedService() {
		return wantedService;
	}

	public void setWantedService(WantedService wantedService) {
		this.wantedService = wantedService;
	}	
	public Wanted getWanted() {
		return wanted;
	}
	public void setWanted(Wanted wanted) {
		this.wanted = wanted;
	}

	public String load() {
		String result;
		try {
			result = SUCCESS;
			setWantedList(wantedService.getAll());
			setWUList(new ArrayList<Pair<Wanted, Users>>());
			for (Wanted wanted : wantedList) {
				System.out.println("%% " + wanted.getUserId() + " %%");
				getWUList().add(new Pair<Wanted, Users>(wanted, usersService
						.getUserById(wanted.getUserId())));
			}
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	@Override	
	public String execute() {
		int userid= ((Users)ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		wanted.setUserId(userid);
		if(wantedService.sendWanted(wanted))
			return "success";
		else
			return "error";
	}

	public List<Wanted> getWantedList() {
		return wantedList;
	}

	public void setWantedList(List<Wanted> wantedList) {
		this.wantedList = wantedList;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public List<Pair<Wanted, Users>> getWUList() {
		return WUList;
	}

	public void setWUList(List<Pair<Wanted, Users>> wUList) {
		WUList = wUList;
	}
}
