package com.example.test.dao.impl;

import com.example.test.dao.AnswerDao;
import com.example.test.entity.Answer;

public class AnswerDaoImpl extends BaseDaoImpl<Answer> implements AnswerDao {
    public AnswerDaoImpl() {this.setNs("com.example.test.dao.AnswerDao");}

    @Override
    public Answer getByDetail(String Detail) {
        return  this.getSqlSession().selectOne(this.getNs()+"getByDetail", Detail);
    }
}
