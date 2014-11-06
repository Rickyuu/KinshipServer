package com.speed.kinship.dao;

import java.util.Date;

public interface StateDao {

	public int insertState(int userId, Date time, String content, byte[] pic);
	
}
