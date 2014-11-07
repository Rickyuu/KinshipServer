package com.speed.kinship.dao;

import com.speed.kinship.model.Feedback;

public interface FeedbackDao {

	public int insertFeedback(int userId, String content, int stateId);
	
	public Feedback queryFeedbackById(int id);
	
}
