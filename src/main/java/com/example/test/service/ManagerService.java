package com.example.test.service;

import com.example.test.domain.Manager;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface ManagerService {
	public List<Manager> find(Manager manager);
	/**查询所有待审核记录*/
	public List<Manager> findPending(Manager manager);
	public Manager get(Serializable id);
	public void insert(Manager manager);
	public void update(Manager manager);
	public void delete(Serializable id);
	public void delete(Serializable[] ids);
	public Manager login(Manager manager);
	/**查询学生信息*/
	public Manager getStu(Manager manager);
	/**分页查询学生信息*/
	public PageInfo<Manager> findByPage(Manager manager, Integer pageNo, Integer pageSize);
	/**分页查询待审核记录*/
	public PageInfo<Manager> findPendingByPage(Manager manager, Integer pageNo, Integer pageSize);
}
