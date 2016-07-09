package com.fdc.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.fdc.pojo.Collections;
import com.fdc.pojo.Users;
import com.fdc.service.CollectService;

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

	// public String addCollect() {
	// if (op == 0) {
	// userId = (int) ActionContext.getContext().getSession().get("userid");
	// int collectionsId = collectService.addCollect(new Collections(userId,
	// houseNewsId));
	// System.out.print("�ղسɹ�\n");
	// } else {
	// collectService.rmCollectById(collectId);
	// }
	// return null;
	// }
	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String addCollect() {
		System.out.println("checkemail");
		try {

			System.out.println("checkemail11");
			userId = ((Users) ServletActionContext.getRequest().getSession()
					.getAttribute("user")).getId();
			collectId = collectService.checkCollect(new Collections(userId,
					houseNewsId));
			if (-1 == collectId) {
				collectService.addCollect(new Collections(userId, houseNewsId));
				dataMap = new HashMap<String, Object>();
				dataMap.put("collectstate", 1);
			} else {
				collectService.rmCollectById(collectId);
				dataMap = new HashMap<String, Object>();
				dataMap.put("collectstate", 0);
			}
			dataMap.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "checked";
	}
}
