package com.example.test.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 泛型类，基础的DAO接口
 * @CreateDate:	2017-3-11
 */
public interface BaseDao<T> {
	public List<T> find();
	public T get(Serializable id);
	public int insert(T entity);
	public int update(T entity);
	public int delete(Serializable id);
	public void delete(Serializable[] ids);
}
