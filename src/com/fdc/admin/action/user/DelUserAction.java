package com.fdc.admin.action.user;

import com.fdc.admin.service.UsersService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DelUserAction implements Action {
	private UsersService usersService;
	private int userID;

	@Override
	public String execute() throws Exception {
		String result;
		try {
			usersService.deleteUser(userID);
			ActionContext.getContext().put("userList",
					usersService.getUserList());
			result = SUCCESS;
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
