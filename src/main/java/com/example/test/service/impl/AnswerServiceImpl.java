package com.example.test.service.impl;

import com.example.test.dao.AnswerDao;
import com.example.test.entity.Answer;
import com.example.test.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Service("AnswerService")
@Component
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
    public int update(Answer answer) {
        return answerDao.update(answer);
    }

    @Override
    public void delete(Serializable id) {
        answerDao.delete(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        answerDao.delete(ids);
    }

    @Override
    public Answer getByDetail(String detail) {
        return answerDao.getByDetail(detail);
    }
}
