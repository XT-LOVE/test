package com.example.test.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.test.dao.TeacherDao;
import com.example.test.entity.Teacher;
@Repository
public abstract class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao {
    public TeacherDaoImpl() {
        this.setNs("com.example.test.mapper.TeacherMapper.");			//设置命名空间
    }
}
