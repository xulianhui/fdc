package com.fdc.admin.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fdc.admin.pojo.Admins;
import com.fdc.admin.pojo.Comments;
import com.fdc.admin.service.AdminsService;
import com.fdc.admin.service.CommentsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private AdminsService adminsService;
	private Admins admins;
	private String loginMessage;
	private CommentsService cmtService;

	public Admins getAdmins() {
		return admins;
	}

	public void setAdmins(Admins admins) {
		this.admins = admins;
	}

	public AdminsService getAdminsService() {
		return adminsService;
	}

	public void setAdminsService(AdminsService adminsService) {
		this.adminsService = adminsService;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public String login() {
		String result;
		if (adminsService.login(admins)) {
			result = SUCCESS;
			ServletActionContext.getRequest().getSession()
					.setAttribute("LOGIN", admins.getUserName());
			List<Comments> cmtList = cmtService.getCmts();
			System.out.println("\n\n\n\nlist size: " + cmtList.size()
					+ "\n\n\n\n");
			ActionContext.getContext().getSession().put("cmtList", cmtList);
			loginMessage = "";
		}
		else {
			result = ERROR;
			loginMessage = "用户名或密码错误，请重试";
		}
		return result;
	}

	public CommentsService getCmtService() {
		return cmtService;
	}

	public void setCmtService(CommentsService cmtService) {
		this.cmtService = cmtService;
	}
}
