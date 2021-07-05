package com.example.test.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.test.dao.QuestionDao;
import com.example.test.entity.Question;
@Repository
public class QuestionDaoImpl extends BaseDaoImpl< Question> implements QuestionDao {
	public QuestionDaoImpl() {
		this.setNs("com.example.test.dao.QuestionDao.");
	}

	@Override
	public List<Question> createPaper(List<String> ch_no, List<String> type, int paperDif) {
		return this.getSqlSession().selectList(this.getNs()+"createPaper");
	}


//	@Override
//	public List<Question> createPaper(Map map) {
//		return this.getSqlSession().selectOne(this.getNs()+"createPaper",map);
//	}

}
