package com.speed.kinship.controller.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.speed.kinship.controller.StateHandler;
import com.speed.kinship.model.Feedback;
import com.speed.kinship.model.State;
import com.speed.kinship.model.User;

public class StateHandlerImpl implements StateHandler {

	@Override
	public List<State> getFirstNStates(String username, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<State> getNextNStates(String username, int startId, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State addState(User user, Date time, String content, byte[] pic) {
		Map<String, Object> argMap = new HashMap<String, Object>();
		argMap.put("userId", user.getId());
		argMap.put("time", time);
		argMap.put("content", content);
		argMap.put("pic", pic);
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback addFeedback(int stateId, User feedbackCreator, String feedback) {
		// TODO Auto-generated method stub
		return null;
	}

}
