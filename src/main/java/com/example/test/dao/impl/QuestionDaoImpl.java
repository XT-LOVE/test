package com.example.test.dao.impl;

import java.util.List;
import java.util.Map;

import com.example.test.entity.Paper;
import org.springframework.stereotype.Repository;

import com.example.test.dao.QuestionDao;
import com.example.test.entity.Question;
@Repository
public class QuestionDaoImpl extends BaseDaoImpl< Question> implements QuestionDao {
	public QuestionDaoImpl() {
		this.setNs("com.example.test.mapper.QuestionMapper.");
	}

	@Override
	public List<Question> createPaper(Map ch_no, Map type, int paperDif) {
		return this.getSqlSession().selectList(this.getNs()+"createPaper");
	}

//	@Override
//	public List<Question> createPaper(Map map) {
//		return this.getSqlSession().selectOne(this.getNs()+"createPaper",map);
//	}

}
