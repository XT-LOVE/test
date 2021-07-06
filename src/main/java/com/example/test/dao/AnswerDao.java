package com.example.test.dao;
import com.example.test.entity.Answer;

public interface AnswerDao extends BaseDao<Answer> {
    public Answer getByDetail(String Detail);
}
