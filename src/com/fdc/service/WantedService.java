package com.fdc.service;

import java.util.List;

import com.fdc.dao.WantedDAO;
import com.fdc.pojo.Wanted;

public class WantedService {
	private WantedDAO wantedDAO;

	public WantedDAO getWantedDAO() {
		return wantedDAO;
	}

	public void setWantedDAO(WantedDAO wantedDAO) {
		this.wantedDAO = wantedDAO;
	}
	
	public List<Wanted> getAll() {
		return wantedDAO.findAll();
	}
	public  boolean sendWanted(Wanted wanted){
		if(getWantedDAO().savenew(wanted))
			return true;
		return false;
	}
}
