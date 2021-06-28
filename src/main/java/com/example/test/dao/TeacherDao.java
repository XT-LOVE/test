package com.example.test.dao;

import java.util.List;

import com.example.test.domain.Teacher;


public interface TeacherDao extends BaseDao<Teacher>{

    public List<Teacher> findPending(Teacher teacher);
    public Teacher getStu(Teacher teacher);
}
