package com.example.test.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.test.dao.TeacherDao;
import com.example.test.entity.Teacher;
@Repository
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao {
    public TeacherDaoImpl() {
        this.setNs("com.example.test.mapper.TeacherMapper.");			//设置命名空间
    }

    public List<Teacher> findPending(Teacher teacher) {
        return this.getSqlSession().selectList(this.getNs()+"findPending",teacher);
    }

    public Teacher getTea(Teacher teacher) {
        return this.getSqlSession().selectOne(this.getNs()+"getTea",teacher);
    }

}
