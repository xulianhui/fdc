package com.fdc.admin.service;

import java.util.List;

import com.fdc.dao.CommentsDAO;
import com.fdc.pojo.Comments;
import com.opensymphony.xwork2.ActionContext;

public class CommentsService {
	private CommentsDAO commentsDAO;

	public CommentsDAO getCommentsDAO() {
		return commentsDAO;
	}

	public void setCommentsDAO(CommentsDAO commentsDAO) {
		this.commentsDAO = commentsDAO;
	}
	
	public List<Comments> getCmts() {
		return commentsDAO.findAll();
	}
	
	public void deleteComments(int cmtId) {
		commentsDAO.deleteById(cmtId);
	}
	
	public void flushCmts(String cookieName) {
		ActionContext.getContext().getSession().put(cookieName, getCmts());
	}
	
	public List<Comments> getCmtsByCmterId(int id) {
		return commentsDAO.findByComterId(id);
	}
}
