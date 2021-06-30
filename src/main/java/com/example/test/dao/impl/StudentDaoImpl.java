package com.example.test.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.test.dao.StudentDao;
import com.example.test.entity.Student;
@Repository
public abstract class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
	public StudentDaoImpl() {
		this.setNs("com.example.test.mapper.StudentMapper.");			//设置命名空间
	}
}
