package com.example.test.service;
import com.example.test.entity.Answer;

import java.io.Serializable;
import java.util.List;

public interface AnswerService {
    public List<Answer> find();
    public Answer get(Serializable id);
    public void insert(Answer answer);
    public void update(Answer answer);
    public void delete(Serializable id);
    public void delete(Serializable[] ids);
}
