package com.example.test.dao;

import java.util.List;

import com.example.test.domain.Manager;


public interface ManagerDao extends BaseDao<Manager>{

    public List<Manager> findPending(Manager manager);
    public Manager getStu(Manager manager);
}
