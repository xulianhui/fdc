//package com.fdc.admin.dvlp;
//
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.fdc.admin.dao.CommentsDAO;
//import com.fdc.admin.pojo.Comments;
//
//public class TestDelete {
//
//	@Test
//	public void test() {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		CommentsDAO dao = (CommentsDAO) context.getBean("CommentsDAO");
////		Comments cmt = dao.findById(1);
////		System.out.println(dao.findById(1));
////		System.out.println(cmt.getContent());
////		dao.delete(cmt);
////		cmt = dao.findById(1);
//		dao.deleteById(1);
//		Comments cmt = dao.findById(1);
//		if (null == cmt) {
//			System.out.println("deleted 1`");
//		}
//		else {
//			System.out.println("error");
//		}
//	}
//}
