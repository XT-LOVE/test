package com.example.test.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.test.dao.QuestionDao;
import com.example.test.entity.Question;
@Repository
public class QuestionDaoImpl extends BaseDaoImpl< Question> implements QuestionDao {
	public QuestionDaoImpl() {
		this.setNs("edu.fjnu.online.mapper.QuestionMapper.");
	}

	public List<Question> createPaper(Map map) {
		return this.getSqlSession().selectList(this.getNs()+"createPaper", map);
	}
}
