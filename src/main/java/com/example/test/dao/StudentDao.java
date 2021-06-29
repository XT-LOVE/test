package com.example.test.dao;

import java.util.List;

import com.example.test.domain.Student;


public interface StudentDao extends BaseDao<Student>{

	public static List<Student> findPending(Student student) {
		return null;
	}

	public Student getStu(Student student);
}
