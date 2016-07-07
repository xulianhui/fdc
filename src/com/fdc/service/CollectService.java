package com.fdc.service;

import java.util.Iterator;
import java.util.List;

import com.fdc.dao.CollectionsDAO;
import com.fdc.pojo.Collections;

public class CollectService {
	CollectionsDAO collectionsDAO;
	
	
	public CollectionsDAO getCollectionsDAO() {
		return collectionsDAO;
	}


	public void setCollectionsDAO(CollectionsDAO collectionsDAO) {
		this.collectionsDAO = collectionsDAO;
	}


	public int addCollect(Collections collections) {
		collectionsDAO.save(collections);
		List<Collections> sadList = collectionsDAO.findByUserId(collections.getUserId());
		for (Collections e : sadList) {
			if (e.getHouseNewsId() == collections.getHouseNewsId()) {
				return e.getId();
			}
		}
		return -1;
	}
	
	public boolean rmCollectById(int id) {
		collectionsDAO.delete(collectionsDAO.findById(id));
		return true;
	}
}
