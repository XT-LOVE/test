package com.example.test.service;

import com.example.test.entity.Teacher;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface TeacherService {
	public List<Teacher> find(Teacher teacher);
	/**查询所有待审核记录*/
	public List<Teacher> findPending(Teacher teacher);
	public Teacher get(Serializable id);
	public void insert(Teacher teacher);
	public void update(Teacher teacher);
	public void delete(Serializable id);
	public void delete(Serializable[] ids);
	public Teacher login(Teacher teacher);
	/**查询学生信息*/
	public Teacher getTea(Teacher teacher);
	/**分页查询学生信息*/
	public PageInfo<Teacher> findByPage(Teacher teacher, Integer pageNo, Integer pageSize);
	/**分页查询待审核记录*/
	public PageInfo<Teacher> findPendingByPage(Teacher teacher, Integer pageNo, Integer pageSize);
}
