//package com.fdc.admin.dvlp.cmt;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.fdc.admin.dao.CommentsDAO;
//import com.fdc.admin.pojo.Comments;
//
//public class TestShByID {
//
//	@Test
//	public void test() {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		// CommentsService service = (CommentsService) context
//		// .getBean("CommentsService");
//		// List<Comments> cmtList = service.getCmtsByCmterId(7);
//		// for (Comments cmt : cmtList) {
//		// System.out.println(cmt.getContent());
//		// }
//		CommentsDAO dao = (CommentsDAO) context.getBean("CommentsDAO");
//		List<Comments> cmtList = dao.findByComterId(7);
//		for (Comments cmt : cmtList) {
//			System.out.println(cmt.getContent());
//		}
//
//		// List<Comments> cmtList = dao.findAll();
//		// for (Comments cmt : cmtList) {
//		// System.out.println(cmt.getContent());
//		// }
//
//		// Comments cmt = dao.findById(1);
//		// System.out.println(cmt.getContent());
//	}
//
//}
