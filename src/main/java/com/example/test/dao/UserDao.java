package com.example.test.dao;

import java.util.List;

import com.example.test.domain.Student;


public interface UserDao extends BaseDao<Student>{

	public List<Student> findPending(Student user);
	public Student getStu(Student user);
}
