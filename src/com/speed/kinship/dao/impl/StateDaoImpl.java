package com.speed.kinship.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.speed.kinship.dao.StateDao;
import com.speed.kinship.model.State;
import com.speed.kinship.util.MyBatisUtils;

public class StateDaoImpl implements StateDao {

	@Override
	public int insertState(int userId, Date time, String content, byte[] pic) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("time", time);
		param.put("content", content);
		param.put("pic", pic);
		SqlSession session = MyBatisUtils.getSqlSession();
		session.insert("stateOperation.insertState", param);
		int result = (int) param.get("id");
		MyBatisUtils.closeSession(session);
		return result;
	}

	@Override
	public List<State> queryFirstNStatesByUserName(String userName, int n) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", userName);
		param.put("n", n);
		SqlSession session = MyBatisUtils.getSqlSession();
		List<State> results = session.selectList("stateOperation.queryFirstNStatesByUserName", param);
		MyBatisUtils.closeSession(session);
		return results;
	}

	@Override
	public List<State> queryNextNStatesByUserName(String userName, int startId, int n) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", userName);
		param.put("startId", startId);
		param.put("n", n);
		SqlSession session = MyBatisUtils.getSqlSession();
		List<State> results = session.selectList("stateOperation.queryNextNStatesByUserName", param);
		MyBatisUtils.closeSession(session);
		return results;
	}

	@Override
	public boolean deleteState(int stateId) {
		SqlSession session = MyBatisUtils.getSqlSession();
		int result = session.delete("stateOperation.deleteState", stateId);
		MyBatisUtils.closeSession(session);
		if(result != 0) {
			return true;
		} else {
			return false;
		}
	}

}
