package com.speed.kinship.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.speed.kinship.dao.FeedbackDao;
import com.speed.kinship.util.MyBatisUtils;

public class FeedbackDaoImpl implements FeedbackDao {

	@Override
	public int insertFeedback(int userId, String content, int stateId) {
		SqlSession session = MyBatisUtils.getSqlSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("content", content);
		param.put("stateId", stateId);
		session.insert("feedbackOperation.insertFeedback", param);
		int result = (int) param.get("id");
		MyBatisUtils.closeSession(session);
		return result;
	}

	@Override
	public boolean deleteFeedback(int feedbackId) {
		SqlSession session = MyBatisUtils.getSqlSession();
		int result = session.delete("feedbackOperation.deleteFeedback", feedbackId);
		MyBatisUtils.closeSession(session);
		if(result != 0) {
			return true;
		} else {
			return false;
		}
	}

}
