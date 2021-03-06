package com.example.test.service.impl;

import com.example.test.dao.TeacherDao;
import com.example.test.entity.Teacher;
import com.example.test.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.util.MD5Util;
import java.io.Serializable;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;

	@Override
	public List<Teacher> find() {
		// TODO Auto-generated method stub
		return teacherDao.find();
	}

	@Override
	public Teacher get(Serializable id) {
		// TODO Auto-generated method stub
		return teacherDao.get(id);
	}

	@Override
	public void insert(Teacher teacher) {
		teacherDao.insert(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.update(teacher);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		teacherDao.delete(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
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

	@Override
	public PageInfo<Teacher> findByPage(Teacher teacher, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Teacher> list = teacherDao.find();
		System.out.println(list.toString());
		//用PageInfo对结果进行包装
		PageInfo<Teacher> page = new PageInfo<Teacher>(list);
		return page;
	}

}
