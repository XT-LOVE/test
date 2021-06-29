package com.example.test.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import com.example.test.entity.Type;

public interface TypeService {
	public List<Type> find(Type type);
	public Type get(int id);
	public void insert(Type type);
	public void update(Type type);
	public void delete(int id);
	public PageInfo<Type> findByPage(Type type, Integer pageNo,Integer pageSize);
}
