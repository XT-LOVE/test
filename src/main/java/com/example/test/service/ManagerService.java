package com.example.test.service;

import com.example.test.entity.Manager;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface ManagerService {
	public static List<Manager> find() {
		return null;
	}

	public static Manager get(Serializable id) {
		return null;
	}

	public static void insert(Manager manager) {
	}

	public static void update(Manager manager) {

	}

	public static void delete(Serializable id) {

	}

	public void delete(Serializable[] ids);
	public Manager login(Manager manager);
	/**分页查询学生信息*/
	public PageInfo<Manager> findByPage(Manager manager, Integer pageNo, Integer pageSize);
}
