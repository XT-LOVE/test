package com.example.test.service.impl;

import com.example.test.dao.AnswerDao;
import com.example.test.entity.Answer;
import com.example.test.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerDao answerDao;
    @Override
    public List<Answer> find() {
        return answerDao.find();
    }

    @Override
    public Answer get(Serializable id) {
        return answerDao.get(id);
    }

    @Override
    public void insert(Answer answer) {
        answerDao.insert(answer);
    }

    @Override
    public void update(Answer answer) {
        answerDao.update(answer);
    }

    @Override
    public void delete(Serializable id) {
        answerDao.delete(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        answerDao.delete(ids);
    }
}
