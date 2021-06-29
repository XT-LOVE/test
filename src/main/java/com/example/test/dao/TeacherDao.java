package com.example.test.dao;

import java.util.List;

import com.example.test.domain.Teacher;


public interface TeacherDao extends BaseDao<Teacher>{

    public static List<Teacher> findPending(Teacher teacher) {
        return null;
    }

    public Teacher getTea(Teacher teacher);
}
