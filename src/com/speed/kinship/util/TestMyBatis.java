package com.speed.kinship.util;

import org.apache.ibatis.session.SqlSession;

import com.speed.kinship.controller.UserHandler;
import com.speed.kinship.controller.impl.UserHandlerImpl;
import com.speed.kinship.model.Identity;
import com.speed.kinship.model.User;

public class TestMyBatis {

//	public static void main(String args[]) {
//		SqlSession session = MyBatisUtils.getSqlSession();
//		User user = session.selectOne("userOperation.queryUserById", 1);
//		System.out.println(user.getId() + " " + user.getUserName() + " " + user.getPassword() + " " + user.getIdentity());
//		MyBatisUtils.closeSession(session);
//	}
	
//	public static void main(String args[]) {
//		SqlSession session = MyBatisUtils.getSqlSession();
//		User user = new User();
//		user.setUserName("rickyuu");
//		user.setPassword("123");
//		user.setIdentity(Identity.CHILD);
//		int result = session.insert("userOperation.insertUser", user);
//		System.out.println(result + " " + user.getId());
//		MyBatisUtils.closeSession(session);
//	}
	
	public static void main(String args[]) {
		UserHandler userHandler = new UserHandlerImpl();
		User user = userHandler.register("rickyuu", "123", Identity.CHILD);
		System.out.println(user.getId());
	}
	
}
