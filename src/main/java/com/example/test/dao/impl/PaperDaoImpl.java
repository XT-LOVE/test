package com.example.test.dao.impl;

import java.util.List;
import java.util.Map;

import com.example.test.entity.Question;
import org.springframework.stereotype.Repository;

import com.example.test.dao.PaperDao;
import com.example.test.entity.Paper;
@Repository
public class PaperDaoImpl extends BaseDaoImpl<Paper> implements PaperDao{
	public PaperDaoImpl() {
		this.setNs("com.example.test.dao.PaperDao.");
	}

	public List<Question> getPaperDetail(Map map) {
		return this.getSqlSession().selectOne(this.getNs()+"getPaperDetail", map);
	}

	public void updatePaper(Map map) {
		this.getSqlSession().selectOne(this.getNs() + "updatePaper", map);
	}
}
