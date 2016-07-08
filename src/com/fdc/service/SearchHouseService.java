package com.fdc.service;

import java.util.List;

import com.fdc.dao.HouseNewsDAO;
import com.fdc.pojo.HouseNews;

public class SearchHouseService {
	private HouseNewsDAO houseNewsDAO;

	public HouseNewsDAO getHouseNewsDAO() {
		return houseNewsDAO;
	}

	public void setHouseNewsDAO(HouseNewsDAO houseNewsDAO) {
		this.houseNewsDAO = houseNewsDAO;
	}
	
	@SuppressWarnings("unchecked")
	public List<HouseNews> getHouse(String region, int lfloor, int rfloor, 
			int lprice, int rprice, int larea, int rarea, int newstype) {
		
		String[] PropertyName;
		Object[] Value;
		if(region.equals("houseRegion") == true) {
			PropertyName = new String[4];
			PropertyName[0] = "newsType";
			PropertyName[1] = "houseFloor";
			PropertyName[2] = "housePrice";
			PropertyName[3] = "houseArea";
			Value = new Object[7];
			Value[0] = newstype;
			Value[1] = lfloor;
			Value[2] = rfloor;
			Value[3] = lprice;
			Value[4] = rprice;
			Value[5] = larea;
			Value[6] = rarea;
			
		}
		
		else {
			PropertyName = new String[5];
			PropertyName[0] = "newsType";
			PropertyName[1] = "houseFloor";
			PropertyName[2] = "housePrice";
			PropertyName[3] = "houseArea";
			PropertyName[4] = "houseReg";
			Value = new Object[8];
			
			Value[0] = newstype;
			Value[1] = lfloor;
			Value[2] = rfloor;
			Value[3] = lprice;
			Value[4] = rprice;
			Value[5] = larea;
			Value[6] = rarea;
			Value[7] = region;
			
		}// System.out.println("------------------------------------");
		List<HouseNews> list = houseNewsDAO.FindByProperty(PropertyName, Value);
		//System.out.println("*****************************************");
		//System.out.println(list.size());
		return list;
	}

}
