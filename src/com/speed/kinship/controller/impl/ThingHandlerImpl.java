package com.speed.kinship.controller.impl;

import java.util.Date;
import java.util.List;

import com.speed.kinship.controller.ThingHandler;
import com.speed.kinship.dao.ThingDao;
import com.speed.kinship.dao.impl.ThingDaoImpl;
import com.speed.kinship.model.Thing;
import com.speed.kinship.model.User;

public class ThingHandlerImpl implements ThingHandler {

	@Override
	public List<Thing> getFirstNThings(String username, int n) {
		ThingDao thingDao = new ThingDaoImpl();
		return thingDao.queryFirstNThingsByUserName(username, n);
	}

	@Override
	public List<Thing> getNextNThings(String username, Date startTime, int n) {
		ThingDao thingDao = new ThingDaoImpl();
		return thingDao.queryNextNThingsByUserName(username, startTime, n);
	}

	@Override
	public Thing addThing(User user, String title, Date time, String content, byte[] pic) {
		ThingDao thingDao = new ThingDaoImpl();
		int id = thingDao.insertThing(user.getId(), title, time, content, pic);
		Thing thing = new Thing();
		thing.setId(id);
		thing.setCreator(user);
		thing.setTitle(title);
		thing.setTime(time);
		thing.setContent(content);
		thing.setPic(pic);
		return thing;
	}

	@Override
	public boolean deleteThing(int thingId) {
		ThingDao thingDao = new ThingDaoImpl();
		return thingDao.deleteThing(thingId);
	}

}
