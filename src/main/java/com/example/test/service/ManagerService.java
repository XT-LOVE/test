package com.example.test.service;

import com.example.test.entity.Manager;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface ManagerService {
	List<Manager> find();

	Manager get(Serializable id);

	void insert(Manager manager);

	void update(Manager manager);

	void delete(Serializable id);

	void delete(Serializable[] ids);

	Manager login(Manager manager);

	PageInfo<Manager> findByPage(Manager manager, Integer pageNo, Integer pageSize);
}
