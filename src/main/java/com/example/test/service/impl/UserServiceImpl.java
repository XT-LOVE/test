package com.example.test.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.example.test.dao.StudentDao;
import com.example.test.domain.Student;
import com.example.test.service.UserService;
import com.example.test.util.MD5Util;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	StudentDao userDao;
	
	public List<Student> find(Student user) {
		// TODO Auto-generated method stub
		return userDao.find(user);
	}

	public Student get(Serializable id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	public void insert(Student user) {
		String userPwd = user.getUserPwd();
		//密码加密
		userPwd = MD5Util.getData(userPwd);
		user.setUserPwd(userPwd);
		userDao.insert(user);
	}

	public void update(Student user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public Student login(Student user) {
		// TODO Auto-generated method stub
		Student u = get(user.getUserId());
		if(u!=null){
			String userPwd = MD5Util.getData(user.getUserPwd());
			if(userPwd.equals(u.getUserPwd())){
				return u;
			}
		}
		return null;
	}

	public List<Student> findPending(Student user) {
		// TODO Auto-generated method stub
		return userDao.findPending(user);
	}

	public Student getStu(Student user) {
		// TODO Auto-generated method stub
		return userDao.getStu(user);
	}

	public PageInfo<Student> findByPage(Student user, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Student> list = userDao.find(user);
	    System.out.println(list.toString());
	    //用PageInfo对结果进行包装
	    PageInfo<Student> page = new PageInfo<Student>(list);
	    return page;
	}

	public PageInfo<Student> findPendingByPage(Student user, Integer pageNo,
											   Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Student> list = userDao.findPending(user);
	    System.out.println(list.toString());
	    //用PageInfo对结果进行包装
	    PageInfo<Student> page = new PageInfo<Student>(list);
	    return page;
	}

}
