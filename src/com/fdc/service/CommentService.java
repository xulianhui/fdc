package com.fdc.service;

import com.fdc.action.CommentAction;
import com.fdc.dao.CommentsDAO;
import com.fdc.pojo.Comments;

public class CommentService {
	CommentsDAO commentsDAO;

	public CommentsDAO getCommentsDAO() {
		return commentsDAO;
	}

	public void setCommentsDAO(CommentsDAO commentsDAO) {
		this.commentsDAO = commentsDAO;
	}

	public boolean setComment(Comments com) {
		commentsDAO.save(com);
		return true;
	}
}
