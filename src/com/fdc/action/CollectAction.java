package com.fdc.action;

import com.fdc.dao.CollectionsDAO;
import com.fdc.pojo.Collections;
import com.fdc.service.CollectService;
import com.opensymphony.xwork2.ActionContext;

public class CollectAction {
	int houseNewsId;
	int userId;
	int collectId;
	int op;
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public int getCollectId() {
		return collectId;
	}
	public void setCollectId(int collectId) {
		this.collectId = collectId;
	}

	CollectService collectService;

	public CollectService getCollectService() {
		return collectService;
	}
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}
	public int getHouseNewsId() {
		return houseNewsId;
	}
	public void setHouseNewsId(int houseNewsId) {
		this.houseNewsId = houseNewsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String addCollect() {
		if (op == 0) {
			userId = (int) ActionContext.getContext().getSession().get("userid");
			int collectionsId = collectService.addCollect(new Collections(userId, houseNewsId));
		} else {
			collectService.rmCollectById(collectId);
		}
		
		return null;
	}
	
}
