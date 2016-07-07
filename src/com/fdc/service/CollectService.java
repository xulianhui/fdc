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

	private int getCollectionsId(Collections collections) {
		List<Collections> sadList = collectionsDAO.findByUserId(collections
				.getUserId());
		System.out.println(sadList.size());
		for (int i = 0; i < sadList.size(); ++i) {
			Collections e = sadList.get(i);
			if (e.getHouseNewsId().equals(collections.getHouseNewsId())) {
				return e.getId();
			}
			System.out
					.printf("e.getId %d; e.getHouseNewsId %d collections.getHouseNewsId %d\n",
							e.getId(), e.getHouseNewsId(),
							collections.getHouseNewsId());
		}
		return -1;
	}

	public int addCollect(Collections collections) {
		collectionsDAO.save(collections);
		return getCollectionsId(collections);
	}

	public boolean rmCollectById(int id) {
		collectionsDAO.delete(collectionsDAO.findById(id));
		return true;
	}

	public int checkCollect(Collections collections) {
		return getCollectionsId(collections);
	}
	
	public List<?> findHouseNews(int _usrId) {
		
		List res = collectionsDAO.findByUserId(_usrId);
		
		
		return res;
	}

}
