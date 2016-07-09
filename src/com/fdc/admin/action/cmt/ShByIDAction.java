package com.fdc.admin.action.cmt;

import java.util.List;

import com.fdc.admin.pojo.Comments;
import com.fdc.admin.service.CommentsService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ShByIDAction implements Action {
	private String shUserIdStr;
	private CommentsService commentsService;

	@Override
	public String execute() throws Exception {
		String result;
		int shUserId = Integer.parseInt(shUserIdStr);
		try {
			if (commentsService == null) {
				System.out.println("ERROR no commentsService");
			}
			else {
				System.out.println("commentsService exist");
			}
			List<Comments> cmtList = commentsService.getCmtsByCmterId(shUserId);
			result = SUCCESS;
			if (null != cmtList && cmtList.size() != 0) {
				ActionContext.getContext().put("cmtList", cmtList);
			}
			else {
				ActionContext.getContext().put("resultMessage", "无此用户的评论");
			}
		} catch(Exception exception) {
			System.err.println(exception.getMessage());
			result = ERROR;
		}
		return result;
	}

	public String getShUserIdStr() {
		return shUserIdStr;
	}
	
	public void setShUserIdStr(String shUserIdStr) {
		this.shUserIdStr = shUserIdStr;
	}

	public CommentsService getCommentsService() {
		return commentsService;
	}

	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}
}
