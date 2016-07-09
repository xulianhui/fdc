package com.fdc.action;

import java.util.*;

import com.fdc.pojo.HouseNews;
import com.fdc.service.SearchHouseService;
import com.fdc.util.SearchHouseSortByPrice;
import com.opensymphony.xwork2.ActionSupport;

public class SearchHouseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int p;                                    	//页码
	private int totalpage;								//总页数
	private int pagenumber;                             //页码数目
	private int newstype;							  	//房屋信息类型（租房/售房）
	private String region;								//房屋所在地区
	private String floor;								//房屋楼层
	private String area;								//房屋面积
	private String price;								//房屋价格
	private String sorting;								//排序
	private String message;								//信息
	private HouseNews houseNews;						//房屋对象
	private SearchHouseService searchHouseService;		//service
	
	
	private String priceunit;                           //价格单位
	private List<String> priceinterval;					//租售价格区间不一样
	private List<HouseNews> list;						//查询信息结果集合
	private List<HouseNews> houseList;                  //当前页显示房屋信息集合

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	
	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	
	

	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}

	public int getNewstype() {
		return newstype;
	}

	public void setNewstype(int newstype) {
		this.newstype = newstype;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HouseNews getHouseNews() {
		return houseNews;
	}

	public void setHouseNews(HouseNews houseNews) {
		this.houseNews = houseNews;
	}

	public SearchHouseService getSearchHouseService() {
		return searchHouseService;
	}

	public void setSearchHouseService(
			SearchHouseService searchHouseService) {
		this.searchHouseService = searchHouseService;
	}
	
	public String getPriceunit() {
		return priceunit;
	}

	public void setPriceunit(String priceunit) {
		this.priceunit = priceunit;
	}

	public List<String> getPriceinterval() {
		return priceinterval;
	}

	public void setPriceinterval(List<String> priceinterval) {
		this.priceinterval = priceinterval;
	}

	public List<HouseNews> getList() {
		return list;
	}

	public void setList(List<HouseNews> list) {
		this.list = list;
	}
	
	
	
	public List<HouseNews> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<HouseNews> houseList) {
		this.houseList = houseList;
	}

	public String initHouse() {
		String Region = "houseRegion";
		int lprice = 0, rprice = 1000000000;
		int lfloor = 0, rfloor = 1000; 
		int larea = 0, rarea = 1000000000;
		region = "0";
		floor = "0";
		price = "0";
		area = "0";
		sorting = "0";
		pagenumber = 3;

		priceinterval = new ArrayList<String>();
		if(newstype == 0) {
			priceunit = "元";
			priceinterval.add("不限");
			priceinterval.add("500以下");
			priceinterval.add("500 - 1000");
			priceinterval.add("1000 - 2000");
			priceinterval.add("2000 - 3000");
			priceinterval.add("3000 - 5000");
			priceinterval.add("5000以上");
		} else {
			priceunit = "万元";
			priceinterval.add("不限");
			priceinterval.add("50以下");
			priceinterval.add("50 - 100");
			priceinterval.add("100 - 200");
			priceinterval.add("200 - 300");
			priceinterval.add("300 - 500");
			priceinterval.add("500以上");

		}
		
		try {
			list = searchHouseService.getHouse(Region, lfloor, rfloor, lprice, rprice, larea, rarea, newstype);
			
			houseList = new ArrayList<HouseNews>();
			totalpage = list.size() / pagenumber;
			if(list.size() % pagenumber > 0) totalpage += 1;

			if(list.size() == 0) {
				message = "没有相关房屋信息！";
			}
			else {
				Collections.reverse(list);
				for(int i = 0; i < pagenumber && i < list.size(); ++i) {
					houseList.add(list.get(i));
				}
				message = "温馨提示：点击图片可查看详情";
			}
			return SUCCESS;
		}catch(Exception e) {
			return ERROR;
		}
	}
	
	public String findHouse() {		
		
		priceinterval = new ArrayList<String>();
		if(newstype == 0) {
			priceunit = "元";
			priceinterval.add("不限");
			priceinterval.add("500以下");
			priceinterval.add("500 - 1000");
			priceinterval.add("1000 - 2000");
			priceinterval.add("2000 - 3000");
			priceinterval.add("3000 - 5000");
			priceinterval.add("5000以上");
		} else {
			priceunit = "万元";
			priceinterval.add("不限");
			priceinterval.add("50以下");
			priceinterval.add("50 - 100");
			priceinterval.add("100 - 200");
			priceinterval.add("200 - 300");
			priceinterval.add("300 - 500");
			priceinterval.add("500以上");
		}
		
		String Region = "houseRegion";
		int lprice = 0, rprice = 1000000000;
		int lfloor = 0, rfloor = 1000; 
		int larea = 0, rarea = 1000000000;
		pagenumber = 3;
		
		switch(Integer.parseInt(region)) {
		
		case 0  : Region = "houseRegion"; break;
		case 1  : Region = "洪山区"; break;
		case 2  : Region = "武昌区";	 break;
		case 3  : Region = "江岸区"; break;
		case 4  : Region = "东湖高新区"; break;
		case 5  : Region = "江汉区"; break;
		case 6  : Region = "汉阳区"; break;
		case 7  : Region = "硚口区"; break;
		case 8  : Region = "东西湖区"; break;
		case 9  : Region = "青山区"; break;
		case 10 : Region = "黄陂区"; break;
		case 11 : Region = "沌口区"; break;
		case 12 : Region = "江夏区"; break;
		case 13 : Region = "蔡甸区"; break;
		case 14 : Region = "汉南区"; break;
		case 15 : Region = "新洲区"; break;
		default : break;
		}
		
		switch(Integer.parseInt(floor)) {
		case 0  : lfloor = 1;  rfloor = 1000; break;
		case 1  : lfloor = 1;  rfloor = 1;    break;
		case 2  : lfloor = 2;  rfloor = 2;    break;
		case 3  : lfloor = 3;  rfloor = 3;    break;
		case 4  : lfloor = 4;  rfloor = 4;    break;
		case 5  : lfloor = 5;  rfloor = 5;    break;
		case 6  : lfloor = 6;  rfloor = 6;    break;
		case 7  : lfloor = 7;  rfloor = 7;    break;
		case 8  : lfloor = 8;  rfloor = 8;    break;
		case 9  : lfloor = 9;  rfloor = 9;    break;
		case 10 : lfloor = 10; rfloor = 10;   break;
		case 11 : lfloor = 11; rfloor = 11;   break;
		case 12 : lfloor = 12; rfloor = 12;   break;
		case 13 : lfloor = 13; rfloor = 1000; break;
		default : break;
		}
		
		switch(Integer.parseInt(area)) {
		case 0  : larea = 0;   rarea = 1000000000; break;
		case 1  : larea = 30;  rarea = 40;         break;
		case 2  : larea = 40;  rarea = 60;         break;
		case 3  : larea = 60;  rarea = 80;         break;
		case 4  : larea = 80;  rarea = 100;		   break;
		case 5	: larea = 100; rarea = 120;		   break;
		case 6	: larea = 120; rarea = 150;		   break;
		case 7	: larea = 150; rarea = 1000000000; break;
		default : break;
		}
		if(newstype == 0) {
			switch(Integer.parseInt(price)) {
			case 0 : lprice = 0;    rprice = 1000000000;    break;
			case 1 : lprice = 0;    rprice = 500;  			break;
			case 2 : lprice = 500;  rprice = 1000;			break;
			case 3 : lprice = 1000; rprice = 2000;		    break;
			case 4 : lprice = 2000; rprice = 3000; 			break; 
			case 5 : lprice = 3000; rprice = 5000; 			break;
			case 6 : lprice = 5000; rprice = 1000000000;    break;
			default: break;
			}
		} else {
			switch(Integer.parseInt(price)) {
			case 0 : lprice = 0;    	rprice = 1000000000;    break;
			case 1 : lprice = 0;	    rprice = 500000;  	    break;
			case 2 : lprice = 500000;   rprice = 1000000;		break;
			case 3 : lprice = 1000000;  rprice = 2000000;	    break;
			case 4 : lprice = 2000000;  rprice = 3000000; 		break; 
			case 5 : lprice = 3000000;  rprice = 5000000; 		break;
			case 6 : lprice = 5000000;  rprice = 1000000000;    break;
			default: break;
			}
		}
		
		try {
			list = searchHouseService.getHouse(Region, lfloor, rfloor, lprice, rprice, larea, rarea, newstype);
			houseList = new ArrayList<HouseNews>();
			totalpage = list.size() / pagenumber;
			if(list.size() % pagenumber > 0) totalpage += 1;

			if(list.size() == 0) {
				message = "没有相关房屋信息！";
			}
			else {
				//System.out.println(sorting);
				Collections.reverse(list);
				if(Integer.parseInt(sorting) == 0) {
					for(int i = 0; i < pagenumber && i < list.size(); ++i) {
						houseList.add(list.get(i));
					}
				}
				else if(Integer.parseInt(sorting) == 1) {
					//System.out.println("!!!!!!!!!!!");
					Collections.sort(list, new SearchHouseSortByPrice());
					for(int i = 0; i < pagenumber && i < list.size(); ++i) {
						houseList.add(list.get(i));
					}
				}
				else {
					Collections.sort(list, new SearchHouseSortByPrice());
					for(int i = list.size() - 1; i >= list.size() - pagenumber && i >= 0; --i) {
						houseList.add(list.get(i));
					}
				}
				
				message = "温馨提示：点击图片可查看详情";
			}
			return SUCCESS;
		}catch(Exception e) {
			return ERROR;
		}
	}

	public String paging() {
		try {
			houseList = new ArrayList<HouseNews>();
			if(Integer.parseInt(sorting) <= 1) {
				for(int i = (p - 1) * pagenumber; i < p * pagenumber && i < list.size(); ++i) {
					houseList.add(list.get(i));
				}
			}
			else {
				for(int i = list.size() - 1 - (p - 1) * pagenumber; i >= list.size() - p * pagenumber && i >= 0; --i) {
					houseList.add(list.get(i));
				}
			}
			return SUCCESS;
		}catch(Exception e) {
			return ERROR;
		}
	}
}
