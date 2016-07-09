package com.fdc.admin.action;

import java.util.List;

import com.fdc.pojo.Users;
import com.fdc.admin.service.UsersService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoadUsersAction implements Action {
	private UsersService usersService;

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@Override
	public String execute() throws Exception {
		String result;
		try {
			List<Users> userList = usersService.getUserList();
			ActionContext.getContext().put("userList", userList);
			// ActionContext.getContext().put("searchForm", SH_BYID);
			result = SUCCESS;
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	// private static final String SH_BYID =
	// "<form action=\"UserSh-byID\" method=\"post\" class=\"form-inline\">"
	// + "用户 ID："
	// + "<input type=\"text\" name=\"userID\" class=\"form-control\" />"
	// + "<input type=\"submit\" value=\"查找用户\" class=\"btn btn-default\" /> "
	// + "</form>";
}
