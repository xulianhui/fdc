package com.fdc.action;

import java.util.List;

import com.fdc.pojo.Homepage;
import com.fdc.service.HomepageService;

public class HomepageAction {
	private HomepageService service;
	private List<Homepage> homepage;

	public HomepageService getService() {
		return service;
	}

	public void setService(HomepageService service) {
		this.service = service;
	}

	public String execute() {
		homepage = service.show();
		return "success";
	}

	public List<Homepage> getHomepage() {
		return homepage;
	}

	public void setHomepage(List<Homepage> homepage) {
		this.homepage = homepage;
	}
}
