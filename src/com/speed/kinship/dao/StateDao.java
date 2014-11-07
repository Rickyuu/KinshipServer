package com.speed.kinship.dao;

import java.util.Date;
import java.util.List;

import com.speed.kinship.model.State;

public interface StateDao {

	public int insertState(int userId, Date time, String content, byte[] pic);
	
	public List<State> queryFirstNStatesByUserName(String userName, int n);
	
	public List<State> queryNextNStatesByUserName(String userName, int startId, int n);
	
}
