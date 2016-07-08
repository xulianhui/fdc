package com.fdc.util;

import java.util.Comparator;

import com.fdc.pojo.HouseNews;

public class SearchHouseSortByPrice implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		HouseNews house1 = (HouseNews)o1;
		HouseNews house2 = (HouseNews)o2;
		if(house1.getHousePrice() < house2.getHousePrice()) {
			return -1;
		}
		return 1;
	}
	
}


