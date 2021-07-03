package com.example.test.service;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

import com.example.test.entity.Student;
import org.springframework.stereotype.Component;

public interface StudentService {
	public static List<Student> find() {
		return null;
	}

	public static Student get(Serializable id) {
		return null;
	}

	public static void insert(Student student) {

	}

	public static void update(Student student) {

	}

	public static void delete(Serializable id) {

	}

	public void delete(Serializable[] ids);

	public static Student login(Student student) {
		return null;
	}

	//分页查询学生信息
	public static PageInfo<Student> findByPage(Student student, Integer pageNo, Integer pageSize) {
		return null;
	}

	}
