package com.example.test.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import com.example.test.entity.Question;

public interface QuestionService {
	public List<Question> find();
	public Question get(int id);
	public void insert(Question question);
	public int update(Question question);
	public int delete(int id);
	public List<Question> createPaper(List<String> ch_no, List<String> type, int paperDif);
	public PageInfo<Question> findByPage(Integer pageNo,Integer pageSize);
}
