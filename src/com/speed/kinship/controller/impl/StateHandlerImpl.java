package com.speed.kinship.controller.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.speed.kinship.controller.StateHandler;
import com.speed.kinship.dao.FeedbackDao;
import com.speed.kinship.dao.StateDao;
import com.speed.kinship.dao.impl.FeedbackDaoImpl;
import com.speed.kinship.dao.impl.StateDaoImpl;
import com.speed.kinship.model.Feedback;
import com.speed.kinship.model.State;
import com.speed.kinship.model.User;

public class StateHandlerImpl implements StateHandler {

	@Override
	public List<State> getFirstNStates(String username, int n) {
		StateDao stateDao = new StateDaoImpl();
		return stateDao.queryFirstNStatesByUserName(username, n);
	}

	@Override
	public List<State> getNextNStates(String username, int startId, int n) {
		StateDao stateDao = new StateDaoImpl();
		return stateDao.queryNextNStatesByUserName(username, startId, n);
	}

	@Override
	public State addState(User user, String content, byte[] pic) {
		StateDao stateDao = new StateDaoImpl();
		Date time = Calendar.getInstance().getTime();
		int id = stateDao.insertState(user.getId(), time, content, pic);
		State state = new State();
		state.setId(id);
		state.setCreator(user);
		state.setTime(time);
		state.setContent(content);
		state.setPic(pic);
		return state;
	}

	@Override
	public Feedback addFeedback(int stateId, User feedbackCreator, String feedback) {
		FeedbackDao feedbackDao = new FeedbackDaoImpl();
		int id = feedbackDao.insertFeedback(feedbackCreator.getId(), feedback, stateId);
		Feedback result = new Feedback();
		result.setId(id);
		result.setCreator(feedbackCreator);
		result.setContent(feedback);
		return result;
	}

	@Override
	public boolean deleteState(int stateId) {
		StateDao stateDao = new StateDaoImpl();
		return stateDao.deleteState(stateId);
	}

	@Override
	public boolean deleteFeedback(int feedbackId) {
		FeedbackDao feedbackDao = new FeedbackDaoImpl();
		return feedbackDao.deleteFeedback(feedbackId);
	}

}
