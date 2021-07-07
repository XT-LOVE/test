package com.example.test.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.example.test.dao.PaperDao;
import com.example.test.entity.Paper;
@Repository
public class PaperDaoImpl extends BaseDaoImpl<Paper> implements PaperDao{
	public PaperDaoImpl() {
		this.setNs("com.example.test.dao.PaperDao.");
	}

	public String getProNo(Serializable paperId) {
		return this.getSqlSession().selectOne(this.getNs()+"getPaperDetail", paperId);
	}

//	public void updatePaper(Map map) {
//		this.getSqlSession().selectOne(this.getNs() + "updatePaper", map);
//	}
}
