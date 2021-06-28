package com.example.test.service;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

import com.example.test.domain.Student;

public interface UserService {
	public List<Student> find(Student user);
	/**查询所有待审核记录*/
	public List<Student> findPending(Student user);
	public Student get(Serializable id);
	public void insert(Student user);
	public void update(Student user);
	public void delete(Serializable id);
	public void delete(Serializable[] ids);
	public Student login(Student user);
	/**查询学生信息*/
	public Student getStu(Student user);
	/**分页查询学生信息*/
	public PageInfo<Student> findByPage(Student user, Integer pageNo, Integer pageSize);
	/**分页查询待审核记录*/
	public PageInfo<Student> findPendingByPage(Student user, Integer pageNo, Integer pageSize);
}
