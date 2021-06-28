package com.example.test.dao;

import java.util.List;
import java.util.Map;

import com.example.test.domain.Question;

public interface QuestionDao extends BaseDao<Question>{

	public List<Question> createPaper(Map map);
}
