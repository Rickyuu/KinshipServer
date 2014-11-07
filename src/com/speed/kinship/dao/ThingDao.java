package com.speed.kinship.dao;

import java.util.Date;
import java.util.List;

import com.speed.kinship.model.Thing;

public interface ThingDao {

	public int insertThing(int userId, String title, Date time, String content, byte[] pic);
	
	public List<Thing> queryFirstNThingsByUserName(String userName, int n);
	
	public List<Thing> queryNextNThingsByUserName(String userName, Date startTime, int n);
	
}
