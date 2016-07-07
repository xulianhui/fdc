package com.fdc.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.crypto.Data;

import com.fdc.pojo.Comments;
import com.fdc.service.CommentService;

public class CommentAction {
	CommentService commentService;
	Comments comments;

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public String sendComment() {

		// Date date = new Date();
		// java.sql.Date sqdate = new java.sql.Date();

		Date date = new java.util.Date();
		Timestamp addtime = new Timestamp(date.getTime());
		comments.setConTime(addtime);

		System.out.println("comments.getComtedId" + comments.getComtedId());
		System.out.println("comments.getComterId" + comments.getComterId());
		System.out.println("comments.getContent" + comments.getContent());
		System.out.println("comments.getConTime" + comments.getConTime());
		commentService.setComment(comments);
		return "success";
	}
}
