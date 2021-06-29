package com.example.test.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.test.dao.ManagerDao;
import com.example.test.entity.Manager;
@Repository
public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {
    public ManagerDaoImpl() {
        this.setNs("com.example.test.mapper.ManagerMapper.");			//设置命名空间
    }

    public List<Manager> findPending(Manager manager) {
        return this.getSqlSession().selectList(this.getNs()+"findPending",manager);
    }

    public Manager getStu(Manager manager) {
        return this.getSqlSession().selectOne(this.getNs()+"getStu",manager);
    }

}
