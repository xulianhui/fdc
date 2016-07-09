package com.fdc.admin.action;

import java.util.List;

import com.fdc.dao.CommentsDAO;
import com.fdc.pojo.Comments;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoadCmtAction extends ActionSupport {
	private CommentsDAO commentDAO;
	private List<Comments> cmtList;
	
	public String execute() {
		String result;
		try {
			result = SUCCESS;
			setCmtList(commentDAO.findAll());
			ActionContext.getContext().put("cmtList", cmtList);
		} catch(Exception exception) {
			result = ERROR;
			setCmtList(null);
		}
		return result;
	}

	public CommentsDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentsDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public List<Comments> getCmtList() {
		return cmtList;
	}

	public void setCmtList(List<Comments> cmtList) {
		this.cmtList = cmtList;
	}
}
