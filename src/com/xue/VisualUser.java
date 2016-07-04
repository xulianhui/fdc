package com.xue;

import com.fdc.pojo.Users;

public class VisualUser {
	public static Users CreateVisualUser() {
		Users usr = new Users("xuelanghu", "Tom cat", "123", "19140663502",
				"tomcat@gmail.com", true, true, true,
				23, "334531659513233815");
		usr.setId(2);
		return usr;
	}
}
