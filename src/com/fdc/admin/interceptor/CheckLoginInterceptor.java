package com.fdc.admin.interceptor;

import java.util.Map;

import com.fdc.admin.action.LoginAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	public static final String LOGIN_KEY = "LOGIN";
	public static final String LOGIN_PAGE = "WEB-INF/jsp/admin-login.jsp";

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("intercept1");
		Object action = actionInvocation.getAction();
		if (action instanceof LoginAction) {
			System.out.println("trying to login");
			return actionInvocation.invoke();
		}
		System.out.println("intercept1");

		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		String login = (String) session.get(LOGIN_KEY);
		System.out.println("intercept1");

		if (null != login && login.length() > 0) {
			System.out.println("already login");
			return actionInvocation.invoke();
		}
		else {
			return LOGIN_PAGE;
		}
	}
}
