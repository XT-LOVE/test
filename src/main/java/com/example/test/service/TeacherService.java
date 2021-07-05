package com.example.test.service;

import com.example.test.entity.Teacher;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface TeacherService {

	List<Teacher> find();

	Teacher get(Serializable id);

	void insert(Teacher teacher);

	void update(Teacher teacher);

	void delete(Serializable id);

	void delete(Serializable[] ids);

	Teacher login(Teacher teacher);

	PageInfo<Teacher> findByPage(Teacher teacher, Integer pageNo, Integer pageSize);
}
