package com.speed.kinship.util;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.speed.kinship.controller.UserHandler;
import com.speed.kinship.controller.impl.UserHandlerImpl;
import com.speed.kinship.dao.FeedbackDao;
import com.speed.kinship.dao.StateDao;
import com.speed.kinship.dao.impl.FeedbackDaoImpl;
import com.speed.kinship.dao.impl.StateDaoImpl;
import com.speed.kinship.model.Feedback;
import com.speed.kinship.model.Identity;
import com.speed.kinship.model.State;
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
		StateDao stateDao = new StateDaoImpl();
		List<State> states = stateDao.queryFirstNStatesByUserName("rickyuu", 5);
		Iterator<State> iterator = states.iterator();
		while(iterator.hasNext()) {
			State state = iterator.next();
			System.out.println(state.getId() + " " + state.getCreator().getUserName());
		}
		List<State> states2 = stateDao.queryNextNStatesByUserName("rickyuu", 3, 5);
		Iterator<State> iterator2 = states2.iterator();
		while(iterator2.hasNext()) {
			State state = iterator2.next();
			System.out.println(state.getId() + " " + state.getCreator().getUserName());
		}
	}
	
}
