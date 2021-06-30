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
public abstract class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDao managerDao;
	
	public List<Manager> find(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.find(manager);
	}

	public Manager get(Serializable id) {
		// TODO Auto-generated method stub
		return managerDao.get(id);
	}

	public void insert(Manager manager) {
		String managerPwd = manager.getMana_pwd();
		//密码加密
		managerPwd = MD5Util.getData(managerPwd);
		manager.setMana_pwd(managerPwd);
		managerDao.insert(manager);
	}

	public void update(Manager manager) {
		// TODO Auto-generated method stub
		managerDao.update(manager);
	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		managerDao.delete(id);
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

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

	public PageInfo<Manager> findByPage(Manager manager, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Manager> list = managerDao.find(manager);
	    System.out.println(list.toString());
	    //用PageInfo对结果进行包装
	    PageInfo<Manager> page = new PageInfo<Manager>(list);
	    return page;
	}


}
