package com.example.test.dao;

import java.util.List;

import com.example.test.entity.Manager;


public interface ManagerDao extends BaseDao<Manager>{

    public static List<Manager> findPending(Manager manager) {
        return null;
    }

    public Manager getMan(Manager manager);
}
