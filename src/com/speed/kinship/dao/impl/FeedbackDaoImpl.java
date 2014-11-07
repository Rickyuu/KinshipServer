package com.speed.kinship.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.speed.kinship.dao.FeedbackDao;
import com.speed.kinship.model.Feedback;
import com.speed.kinship.util.MyBatisUtils;

public class FeedbackDaoImpl implements FeedbackDao {

	@Override
	public int insertFeedback(int userId, String content, int stateId) {
		SqlSession session = MyBatisUtils.getSqlSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("content", content);
		param.put("stateId", stateId);
		int result = session.insert("feedbackOperation.insertFeedback", param);
		MyBatisUtils.closeSession(session);
		return result;
	}

	@Override
	public Feedback queryFeedbackById(int id) {
		SqlSession session = MyBatisUtils.getSqlSession();
		Feedback feedback = session.selectOne("feedbackOperation.queryFeedbackById", 1);
		MyBatisUtils.closeSession(session);
		return feedback;
	}

}
