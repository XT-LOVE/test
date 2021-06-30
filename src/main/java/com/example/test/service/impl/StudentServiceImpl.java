package com.example.test.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.example.test.dao.StudentDao;
import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import com.example.test.util.MD5Util;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	public List<Student> find(Student student) {
		// TODO Auto-generated method stub
		return studentDao.find(student);
	}

	public Student get(Serializable id) {
		// TODO Auto-generated method stub
		return studentDao.get(id);
	}

	public void insert(Student student) {
		String studentPwd = student.getStu_pwd();
		//密码加密
		studentPwd = MD5Util.getData(studentPwd);
		student.setStu_pwd(studentPwd);
		studentDao.insert(student);
	}

	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		studentDao.delete(id);
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public Student login(Student student) {
		// TODO Auto-generated method stub
		Student u = get(student.getStu_no());
		if(u!=null){
			String studentPwd = MD5Util.getData(student.getStu_pwd());
			if(studentPwd.equals(u.getStu_pwd())){
				return u;
			}
		}
		return null;
	}

	public List<Student> findPending(Student student) {
		// TODO Auto-generated method stub
		return StudentDao.findPending(student);
	}

	public Student getStu(Student student) {
		// TODO Auto-generated method stub
		return studentDao.getStu(student);
	}

	public PageInfo<Student> findByPage(Student student, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Student> list = studentDao.find(student);
	    System.out.println(list.toString());
	    //用PageInfo对结果进行包装
	    PageInfo<Student> page = new PageInfo<Student>(list);
	    return page;
	}

	public PageInfo<Student> findPendingByPage(Student student, Integer pageNo,
											   Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Student> list = StudentDao.findPending(student);
	    System.out.println(list.toString());
	    //用PageInfo对结果进行包装
	    PageInfo<Student> page = new PageInfo<Student>(list);
	    return page;
	}

}