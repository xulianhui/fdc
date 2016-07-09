package com.fdc.admin.action.user;


import com.fdc.admin.service.UsersService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CheckUserAction implements Action {
	private int userID;
	private UsersService usersService;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String execute() throws Exception {
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
		String result;
		try {
			System.out.println("check " + userID);
			getUsersService().check(userID);
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

}
