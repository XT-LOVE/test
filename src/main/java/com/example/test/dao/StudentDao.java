package com.example.test.dao;

import java.util.List;

import com.example.test.entity.Student;


public interface StudentDao extends BaseDao<Student>{

	public List<Student> findPending(Student student);
	public Student getStu(Student student);
}
