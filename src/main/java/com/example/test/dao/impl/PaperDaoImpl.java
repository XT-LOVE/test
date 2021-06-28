package com.example.test.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.test.dao.PaperDao;
import com.example.test.domain.Paper;
@Repository
public class PaperDaoImpl extends BaseDaoImpl<Paper> implements PaperDao{
	public PaperDaoImpl() {
		this.setNs("edu.fjnu.online.mapper.PaperMapper.");
	}

	public List<Paper> getUserPaperById(Serializable id) {
		return this.getSqlSession().selectList(this.getNs()+"getUserPaperById", id);
	}

	public Paper getPaperDetail(Map map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(this.getNs()+"getPaperDetail", map);
	}

	public void updateUserPaper(Map map) {
		// TODO Auto-generated method stub
		this.getSqlSession().selectOne(this.getNs()+"updateUserPaper", map);
	}

	public List<Paper> getUndoPaper(Map map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(this.getNs()+"getUndoPaper", map);
	}

	public List<Paper> qryUndoPaper(Map map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(this.getNs()+"qryUndoPaper", map);
	}
}
