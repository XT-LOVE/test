package com.example.test.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.test.dao.UserDao;
import com.example.test.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public UserDaoImpl() {
		this.setNs("edu.fjnu.online.mapper.UserMapper.");			//设置命名空间
	}

	public List<User> findPending(User user) {
		return this.getSqlSession().selectList(this.getNs()+"findPending",user);
	}

	public User getStu(User user) {
		return this.getSqlSession().selectOne(this.getNs()+"getStu",user);
	}

}
