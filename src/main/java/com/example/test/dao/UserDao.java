package com.example.test.dao;

import java.util.List;

import com.example.test.domain.User;


public interface UserDao extends BaseDao<User>{

	public List<User> findPending(User user);
	public User getStu(User user);
}
