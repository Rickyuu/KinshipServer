package com.speed.kinship.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.speed.kinship.dao.StateDao;
import com.speed.kinship.util.MyBatisUtils;

public class StateDaoImpl implements StateDao {

	@Override
	public int insertState(int userId, Date time, String content, byte[] pic) {
		Map<String, Object> argMap = new HashMap<String, Object>();
		argMap.put("userId", userId);
		argMap.put("time", time);
		argMap.put("content", content);
		argMap.put("pic", pic);
		SqlSession session = MyBatisUtils.getSqlSession();
		// TODO
		return 0;
	}

}
