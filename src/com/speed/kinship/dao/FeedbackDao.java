package com.speed.kinship.dao;

public interface FeedbackDao {

	public int insertFeedback(int userId, String content, int stateId);
	
	public boolean deleteFeedback(int feedbackId);
	
}
