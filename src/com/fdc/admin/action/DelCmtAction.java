package com.fdc.admin.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fdc.admin.pojo.Comments;
import com.fdc.admin.service.CommentsService;
import com.opensymphony.xwork2.ActionSupport;

public class DelCmtAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private CommentsService commentsService;
	private int cmtId;

	public CommentsService getCommentsService() {
		return commentsService;
	}

	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}

	public int getCmtId() {
		return cmtId;
	}

	public void setCmtId(int cmtId) {
		this.cmtId = cmtId;
	}

	public String execute() {
		String result;
		// System.out.println("\n\n\n\ncmtId: " + cmtId + "\n\n\n\n");
		try {
			commentsService.deleteComments(cmtId);
			List<Comments> cmtList = commentsService.getCmts();
			// ServletActionContext.getRequest().getSession();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cmtList", cmtList);
			// ActionContext.getContext().getSession().put("cmtList", cmtList);
			System.out.println("\n\n\n\nlist size: " + cmtList.size());
			result = SUCCESS;
		}
		catch (Exception exception) {
			result = ERROR;
		}
		return result;
	}
}
