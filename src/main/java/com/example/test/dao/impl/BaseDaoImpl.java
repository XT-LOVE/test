package com.example.test.dao.impl;

import com.example.test.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	private String ns;		//命名空间
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}

	public List<T> find() {
		List<T> oList = this.getSqlSession().selectList(ns + "find");
		return oList;
	}
	public T get(Serializable id) {
		return this.getSqlSession().selectOne(ns + "get", id);
	}

	public void insert(T entity) {
		this.getSqlSession().insert(ns + "insert", entity);
	}

	public void update(T entity) {
		this.getSqlSession().update(ns + "update", entity);
	}

	public void delete(Serializable id) {
		this.getSqlSession().delete(ns + "delete", id);
	}

	public void delete(Serializable[] ids) {
		this.getSqlSession().delete(ns + "deleteBatch", ids);
	}
}
