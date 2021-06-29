package com.example.test.service.impl;

import com.example.test.dao.TeacherDao;
import com.example.test.domain.Teacher;
import com.example.test.service.TeacherService;
import com.example.test.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	
	public List<Teacher> find(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.find(teacher);
	}

	public Teacher get(Serializable id) {
		// TODO Auto-generated method stub
		return teacherDao.get(id);
	}

	public void insert(Teacher teacher) {
		String teacherPwd = teacher.getTea_pwd();
		//密码加密
		teacherPwd = MD5Util.getData(teacherPwd);
		teacher.setTea_pwd(teacherPwd);
		teacherDao.insert(teacher);
	}

	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.update(teacher);
	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		teacherDao.delete(id);
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public Teacher login(Teacher teacher) {
		// TODO Auto-generated method stub
		Teacher u = get(teacher.getTea_no());
		if(u!=null){
			String teacherPwd = MD5Util.getData(teacher.getTea_pwd());
			if(teacherPwd.equals(u.getTea_pwd())){
				return u;
			}
		}
		return null;
	}

	public List<Teacher> findPending(Teacher teacher) {
		// TODO Auto-generated method stub
		return TeacherDao.findPending(teacher);
	}

	public Teacher getStu(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.getTea(teacher);
	}

	public PageInfo<Teacher> findByPage(Teacher teacher, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Teacher> list = teacherDao.find(teacher);
	    System.out.println(list.toString());
	    //用PageInfo对结果进行包装
	    PageInfo<Teacher> page = new PageInfo<Teacher>(list);
	    return page;
	}

	public PageInfo<Teacher> findPendingByPage(Teacher teacher, Integer pageNo,
											   Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Teacher> list = TeacherDao.findPending(teacher);
	    System.out.println(list.toString());
	    //用PageInfo对结果进行包装
	    PageInfo<Teacher> page = new PageInfo<Teacher>(list);
	    return page;
	}

}
