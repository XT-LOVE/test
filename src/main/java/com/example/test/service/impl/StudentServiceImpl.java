package com.example.test.service.impl;

import com.example.test.dao.StudentDao;
import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import com.example.test.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    //查询所有学生
    public List<Student> find() {
        return studentDao.find();
    }
    @Override
    //查询单个学生
    public Student get(String id) {
        return studentDao.get(id);
    }
    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }
    @Override
    public void update(Student student) {
        // TODO Auto-generated method stub
        studentDao.update(student);
    }
    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        studentDao.delete(id);
    }
    @Override
    public Student login(Student student) {
        // TODO Auto-generated method stub
        Student u = get(student.getStu_no());
        if(u!=null){
            String studentPwd = MD5Util.getData(student.getStu_pwd());
            if(studentPwd.equals(u.getStu_pwd())){
                return u;
            }
        }
        return null;
    }
    @Override
    public PageInfo<Student> findByPage(Student student, Integer pageNo, Integer pageSize) {
        // TODO Auto-generated method stub
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Student> list = studentDao.find();
        System.out.println(list.toString());
        //用PageInfo对结果进行包装
        PageInfo<Student> page = new PageInfo<Student>(list);
        return page;
    }

}