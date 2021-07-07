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

	@Override
	public List<T> find() {
		List<T> oList = this.getSqlSession().selectList(ns + "find");
		return oList;
	}
	@Override
	public T get(Serializable id) {
		return this.getSqlSession().selectOne(ns + "get", id);
	}
    @Override
	public int insert(T entity) {
		return this.getSqlSession().insert(ns + "insert", entity);
	}
    @Override
	public int update(T entity) {
		return this.getSqlSession().update(ns + "update", entity);
	}
    @Override
	public int delete(Serializable id) {
		return this.getSqlSession().delete(ns + "delete", id);
	}
    @Override
	public void delete(Serializable[] ids) {
		this.getSqlSession().delete(ns + "deleteBatch", ids);
	}
}
