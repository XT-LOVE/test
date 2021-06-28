package com.example.test.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.test.dao.UserDao;
import com.example.test.domain.Student;
@Repository
public class UserDaoImpl extends BaseDaoImpl<Student> implements UserDao{
	public UserDaoImpl() {
		this.setNs("edu.fjnu.online.mapper.UserMapper.");			//设置命名空间
	}

	public List<Student> findPending(Student user) {
		return this.getSqlSession().selectList(this.getNs()+"findPending",user);
	}

	public Student getStu(Student user) {
		return this.getSqlSession().selectOne(this.getNs()+"getStu",user);
	}

}
