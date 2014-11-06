package com.speed.kinship.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.speed.kinship.dao.UserDao;
import com.speed.kinship.model.User;
import com.speed.kinship.util.MyBatisUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public int insertUser(User user) {
		SqlSession session = MyBatisUtils.getSqlSession();
		int id = session.insert("userOperation.insertUser", user);
		MyBatisUtils.closeSession(session);
		return id;
	}

	@Override
	public User queryUserById(int id) {
		SqlSession session = MyBatisUtils.getSqlSession();
		User user = session.selectOne("userOperation.queryUserById", id);
		MyBatisUtils.closeSession(session);
		return user;
	}

	@Override
	public List<User> queryUserByName(String userName) {
		SqlSession session = MyBatisUtils.getSqlSession();
		List<User> users = session.selectList("userOperation.queryUserByName", userName);
		MyBatisUtils.closeSession(session);
		return users;
	}

	@Override
	public User queryUserByNamePassIdentity(User user) {
		SqlSession session = MyBatisUtils.getSqlSession();
		User resultUser = session.selectOne("userOperation.queryUserByNamePassIdentity", user);
		MyBatisUtils.closeSession(session);
		return resultUser;
	}

}
