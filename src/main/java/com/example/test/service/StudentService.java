package com.example.test.service;

import com.example.test.dao.StudentDao;
import com.example.test.entity.Student;
import com.example.test.pagination.Page;
import com.example.test.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public interface StudentService {

	//查询所有学生
	List<Student> find();

	//查询单个学生
	Student get(Serializable id);

	void insert(Student student);

	void update(Student student);

	void delete(Serializable id);

	void delete(Serializable[] ids);

	Student login(Student student);

	PageInfo<Student> findByPage(Student student, Integer pageNo, Integer pageSize);
}
