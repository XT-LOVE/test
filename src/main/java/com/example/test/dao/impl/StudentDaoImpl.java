package com.example.test.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.test.dao.StudentDao;
import com.example.test.domain.Student;
@Repository
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
	public StudentDaoImpl() {
		this.setNs("com.example.test.mapper.StudentMapper.");			//设置命名空间
	}

	public List<Student> findPending(Student student) {
		return this.getSqlSession().selectList(this.getNs()+"findPending",student);
	}

	public Student getStu(Student student) {
		return this.getSqlSession().selectOne(this.getNs()+"getStu",student);
	}

}
