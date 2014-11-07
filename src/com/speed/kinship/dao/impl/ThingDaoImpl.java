package com.speed.kinship.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.speed.kinship.dao.ThingDao;
import com.speed.kinship.model.Thing;
import com.speed.kinship.util.MyBatisUtils;

public class ThingDaoImpl implements ThingDao {

	@Override
	public int insertThing(int userId, String title, Date time, String content, byte[] pic) {
		SqlSession session = MyBatisUtils.getSqlSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("title", title);
		param.put("time", time);
		param.put("content", content);
		param.put("pic", pic);
		int result = session.insert("thingOperation.insertThing", param);
		MyBatisUtils.closeSession(session);
		return result;
	}

	@Override
	public List<Thing> queryFirstNThingsByUserName(String userName, int n) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", userName);
		param.put("n", n);
		SqlSession session = MyBatisUtils.getSqlSession();
		List<Thing> results = session.selectList("thingOperation.queryFirstNThingsByUserName", param);
		MyBatisUtils.closeSession(session);
		return results;
	}

	@Override
	public List<Thing> queryNextNThingsByUserName(String userName, Date startTime, int n) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", userName);
		param.put("startTime", startTime);
		param.put("n", n);
		SqlSession session = MyBatisUtils.getSqlSession();
		List<Thing> results = session.selectList("thingOperation.queryNextNThingsByUserName", param);
		MyBatisUtils.closeSession(session);
		return results;
	}

}
