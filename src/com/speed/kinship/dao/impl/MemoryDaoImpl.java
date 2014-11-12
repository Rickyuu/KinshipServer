package com.speed.kinship.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.speed.kinship.dao.MemoryDao;
import com.speed.kinship.model.Memory;
import com.speed.kinship.util.MyBatisUtils;

public class MemoryDaoImpl implements MemoryDao {

	@Override
	public int insertMemory(int userId, Date time, String content) {
		SqlSession session = MyBatisUtils.getSqlSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("time", time);
		param.put("content", content);
		session.insert("memoryOperation.insertMemory", param);
		int id = (int) param.get("id");
		MyBatisUtils.closeSession(session);
		return id;
	}

	@Override
	public List<Memory> queryMemoriesByUserName(String userName) {
		SqlSession session = MyBatisUtils.getSqlSession();
		List<Memory> memories = session.selectList("memoryOperation.queryMemoriesByUserName", userName);
		MyBatisUtils.closeSession(session);
		return memories;
	}

	@Override
	public boolean deleteMemory(int memoryId) {
		SqlSession session = MyBatisUtils.getSqlSession();
		int result = session.delete("memoryOperation.deleteMemory", memoryId);
		MyBatisUtils.closeSession(session);
		if(result != 0) {
			return true;
		} else {
			return false;
		}
	}

	
	
}
