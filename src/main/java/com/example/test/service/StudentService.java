package com.example.test.service;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

import com.example.test.domain.Student;

public interface StudentService {
	public List<Student> find(Student student);
	/**查询所有待审核记录*/
	public List<Student> findPending(Student student);
	public static Student get(Serializable id);
	public void insert(Student student);
	public void update(Student student);
	public void delete(Serializable id);
	public void delete(Serializable[] ids);

	public static Student login(Student student) {
		return null;
	}

	/**查询学生信息*/
	public Student getStu(Student student);
	/**分页查询学生信息*/
	public PageInfo<Student> findByPage(Student student, Integer pageNo, Integer pageSize);
	/**分页查询待审核记录*/
	public PageInfo<Student> findPendingByPage(Student student, Integer pageNo, Integer pageSize);
}
