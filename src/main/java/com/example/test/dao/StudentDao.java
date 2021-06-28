package com.example.test.dao;

import java.util.List;

import com.example.test.domain.Student;


public interface StudentDao extends BaseDao<Student>{

	public List<Student> findPending(Student student);
	public Student getStu(Student student);
}
