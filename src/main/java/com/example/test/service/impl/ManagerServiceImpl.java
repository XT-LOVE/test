package com.example.test.service.impl;

import com.example.test.dao.ManagerDao;
import com.example.test.entity.Manager;
import com.example.test.service.ManagerService;
import com.example.test.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDao managerDao;

	@Override
	public List<Manager> find() {
		// TODO Auto-generated method stub
		return managerDao.find();
	}

	@Override
	public Manager get(Serializable id) {
		// TODO Auto-generated method stub
		return managerDao.get(id);
	}

	@Override
	public void insert(Manager manager) {
		managerDao.insert(manager);
	}

	@Override
	public void update(Manager manager) {
		// TODO Auto-generated method stub
		managerDao.update(manager);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		managerDao.delete(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public Manager login(Manager manager) {
		// TODO Auto-generated method stub
		Manager u = get(manager.getMana_no());
		if(u!=null){
			String managerPwd = MD5Util.getData(manager.getMana_pwd());
			if(managerPwd.equals(u.getMana_pwd())){
				return u;
			}
		}
		return null;
	}

	@Override
	public PageInfo<Manager> findByPage(Manager manager, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Manager> list = managerDao.find();
		System.out.println(list.toString());
		//用PageInfo对结果进行包装
		PageInfo<Manager> page = new PageInfo<Manager>(list);
		return page;
	}


}
