package com.fdc.admin.action;

import java.util.ArrayList;
import java.util.List;

import com.fdc.pojo.Users;
import com.fdc.admin.service.UsersService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class UserShAction implements Action {

	private Integer userID;
	private String userName;
	private String email;
	private List<Users> userList;

	// Spring Bean
	private UsersService usersService;

	private static final String SH_BYID = "<form action=\"UserSh-byID\" method=\"post\" class=\"form-inline\">"
			+ "用户 ID："
			+ "<input type=\"text\" name=\"userID\" class=\"form-control\" />"
			+ "<input type=\"submit\" value=\"查找用户\" class=\"btn btn-default\" /> "
			+ "</form>";
	
	private static final String SH_BYNAME = "<form action=\"UserSh-byName\" method=\"post\" class=\"form-inline\">"
			+ "用户姓名："
			+ "<input type=\"text\" name=\"userName\" class=\"form-control\" />"
			+ "<input type=\"submit\" value=\"查找用户\" class=\"btn btn-default\" /> "
			+ "</form>";
	
	private static final String SH_BYEMAIL = "<form action=\"UserSh-byEmail\" method=\"post\" class=\"form-inline\">"
			+ "用户电邮："
			+ "<input type=\"text\" name=\"email\" class=\"form-control\" />"
			+ "<input type=\"submit\" value=\"查找用户\" class=\"btn btn-default\" /> "
			+ "</form>";
	
	public String toID() {
		String result;
		try {
			ActionContext.getContext().put("searchForm", SH_BYID);
			result = SUCCESS;
		}
		catch(Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}
	
	public String toName() {
		String result;
		try {
			ActionContext.getContext().put("searchForm", SH_BYNAME);
			result = SUCCESS;
		}
		catch(Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}
	
	public String toEmail() {
		String result;
		try {
			ActionContext.getContext().put("searchForm", SH_BYEMAIL);
			result = SUCCESS;
		}
		catch(Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	public String byID() throws Exception {
		String result;
		try {
			userList = new ArrayList<Users>();
			System.out.println("%% " + getUserID() + " %%");
			userList.add(usersService.getUser(getUserID()));
			ActionContext.getContext().put("searchForm", SH_BYID);
			result = SUCCESS;
		}
		catch (Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}
	
	public String byName() throws Exception {
		String result;
		try {
			userList = usersService.getUserList(userName);
			ActionContext.getContext().put("searchForm", SH_BYNAME);
			result = SUCCESS;
		}
		catch(Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}
	
	public String byEmail() throws Exception {
		String result;
		try {
			userList = usersService.getUsersByEmail(email);
			ActionContext.getContext().put("searchForm", SH_BYNAME);
			result = SUCCESS;
		}
		catch(Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
