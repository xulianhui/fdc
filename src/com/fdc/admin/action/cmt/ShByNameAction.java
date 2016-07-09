package com.fdc.admin.action.cmt;

import java.util.ArrayList;
import java.util.List;

import com.fdc.pojo.Comments;
import com.fdc.pojo.Users;
import com.fdc.admin.service.CommentsService;
import com.fdc.admin.service.UsersService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ShByNameAction implements Action {
	private UsersService usersService;
	private CommentsService commmentsService;
	private String shUserNameStr;

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public CommentsService getCommmentsService() {
		return commmentsService;
	}

	public void setCommmentsService(CommentsService commmentsService) {
		this.commmentsService = commmentsService;
	}

	@Override
	public String execute() throws Exception {
		String result;
		try {
			List<Users> userList = usersService.getUserList(shUserNameStr);
			List<Comments> cmtList = new ArrayList<Comments>();
			for (Users user : userList) {
				cmtList.addAll(commmentsService.getCmtsByCmterId(user.getId()));
			}
			ActionContext.getContext().put("cmtList", cmtList);
			result = SUCCESS;
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	public String getShUserNameStr() {
		return shUserNameStr;
	}

	public void setShUserNameStr(String shUserNameStr) {
		this.shUserNameStr = shUserNameStr;
	}
}
