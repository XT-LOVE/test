package com.example.test.service;

import com.example.test.entity.Manager;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface ManagerService {
	public List<Manager> find(Manager manager);
	public Manager get(Serializable id);
	public void insert(Manager manager);
	public void update(Manager manager);
	public void delete(Serializable id);
	public void delete(Serializable[] ids);
	public Manager login(Manager manager);
	/**分页查询学生信息*/
	public PageInfo<Manager> findByPage(Manager manager, Integer pageNo, Integer pageSize);
}
