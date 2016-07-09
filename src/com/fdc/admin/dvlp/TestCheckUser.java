//package com.fdc.admin.dvlp;
//
//import org.junit.Test;
//
//import com.fdc.admin.dao.UsersDAO;
//import com.fdc.admin.pojo.Users;
//
//public class TestCheckUser {
//
//	@Test
//	public void test() {;
//		UsersDAO dao = (UsersDAO) TestTemplate.getBean("UsersDAO");
//		final int userID = 8;
//		Users user = dao.findById(userID);
//		System.out.println("Find user: " + user.getRealName());
//		System.out.println("Checked  : " + user.getChecked());
//		user.setChecked(false);
//		dao.update(user);
//		user = dao.findById(userID);
//		System.out.println("Find user: " + user.getRealName() + " again");
//		System.out.println("Checked  : " + user.getChecked());
//	}
//
//}
