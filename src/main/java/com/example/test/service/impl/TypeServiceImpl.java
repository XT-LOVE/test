package com.example.test.service.impl;

import com.example.test.dao.TypeDao;
import com.example.test.entity.Type;
import com.example.test.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired
	TypeDao typeDao;
	
	public List<Type> find(Type type) {
		return typeDao.find(type);
	}

	public Type get(int id) {
		return typeDao.get(id);
	}

	public void insert(Type type) {
		typeDao.insert(type);
	}

	public void update(Type type) {
		typeDao.update(type);
	}

	public void delete(int id) {
		typeDao.delete(id);
	}

	public PageInfo<Type> findByPage(Type type, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Type> list = typeDao.find(type);
	    //用PageInfo对结果进行包装
	    PageInfo<Type> page = new PageInfo<Type>(list);
	    return page;
	}

}
