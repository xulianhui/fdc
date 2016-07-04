package com.fdc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fdc.pojo.Homepage;
import com.fdc.pojo.Users;
import com.fdc.service.HomepageService;
import com.fdc.service.UsersService;
import com.opensymphony.xwork2.ActionContext;

public class UsersAction {
	private String regedit_state;
	private String login_state;
	private String email;
	private UsersService service;
	private List<Homepage> homepage;
	private HomepageService mservice;
	private Users users;

	public String getLogin_state() {
		return login_state;
	}

	public void setLogin_state(String login_state) {
		this.login_state = login_state;
	}

	public UsersService getService() {
		return service;
	}

	public void setService(UsersService service) {
		this.service = service;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public HomepageService getMservice() {
		return mservice;
	}

	public void setMservice(HomepageService mservice) {
		this.mservice = mservice;
	}

	public String execute() {
		setHomepage(getMservice().show());
		
		return "success";
	}

	public String login() {
		execute();
		System.out.println("login action执行");
		Users users1 = service.login(getUsers());
		if (users1 != null) {
			login_state = "操作成功";
			ActionContext.getContext().getSession().put("useremail", users1.getEmail());
			ActionContext.getContext().getSession().put("userid", users1.getId());
			ActionContext.getContext().getSession().put("usernickname", users1.getNickName());
			ActionContext.getContext().getSession().put("login_state", login_state);
			System.out.println(users1.getNickName()+"login 成功");
			return "success";
		} else {
			login_state = "操作失败";
			ActionContext.getContext().getSession().clear();
			ActionContext.getContext().getSession()
					.put("login_state", login_state);
			return "error";
		}
	}

	public String loginout() {
		execute();
		System.out.println("loginout action执行");
		login_state = "未登录";
		ActionContext.getContext().getSession().clear();
		ActionContext.getContext().getSession().put("login_state", login_state);
		return "success";
	}
	public String regedit() {
		if (service.regedit(users)) {// 调用增加用户业务方法，判断是否增加成功
			regedit_state = "用户注册成功!";
			ActionContext.getContext().getSession().put("useremail", users.getEmail());
			ActionContext.getContext().getSession().put("userid", users.getId());
			ActionContext.getContext().getSession().put("usernickname", users.getNickName());
		}
		else
			regedit_state = "用户被占用，请重新注册";
		return "ok";
	}
	private Map<String,Object> dataMap;  
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String checkemail() {  
		System.out.println("执行");
		try {
			
			// dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据  
			dataMap = new HashMap<String, Object>();  
			String checkresult="邮箱已存在";
			if(service .checkemail(email))
				checkresult="ok";
			dataMap.put("checkresult", checkresult);  
			// 放入一个是否操作成功的标识  
			dataMap.put("success", true);  
		} catch (Exception e) {
			e.printStackTrace();
		}
        // 返回结果  
        return "checked";  
    }  

	public List<Homepage> getHomepage() {
		return homepage;
	}

	public void setHomepage(List<Homepage> homepage) {
		this.homepage = homepage;
	}

	public String getRegedit_state() {
		return regedit_state;
	}

	public void setRegedit_state(String regedit_state) {
		this.regedit_state = regedit_state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
