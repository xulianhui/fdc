package com.fdc.interceptor;

import org.apache.struts2.ServletActionContext;

import com.fdc.pojo.Users;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		// ActionContext ctx = invocation.getInvocationContext();
		System.out.println("进入拦截器");
		Users loginUsers = (Users) ServletActionContext.getRequest()
				.getSession().getAttribute("user");
		if (loginUsers == null) {
			System.out.println("用户未登录");
			return "login";
		}
		return invocation.invoke();
	}
}
