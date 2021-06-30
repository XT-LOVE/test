package com.example.test.service;

import com.example.test.entity.Teacher;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface TeacherService {
	public static List<Teacher> find() {
		return null;
	}

	public static Teacher get(Serializable id) {
		return null;
	}

	public static void insert(Teacher teacher) {
	}

	public static void update(Teacher teacher) {

	}

	public static void delete(Serializable id) {

	}

	public void delete(Serializable[] ids);
	public Teacher login(Teacher teacher);
	/**分页查询学生信息*/
	public PageInfo<Teacher> findByPage(Teacher teacher, Integer pageNo, Integer pageSize);
}
