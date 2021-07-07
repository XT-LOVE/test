package com.example.test.service;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

import com.example.test.entity.Paper;

public interface PaperService {
	public List<Paper> find(Paper paper);
	public Paper get(Serializable id);
	public int insert(Paper paper);
	public void update(Paper paper);
	public void delete(Serializable id);
	public void delete(Serializable[] ids);
	//查看试卷详情
	public String getProNo(Serializable paperId);
	//更新试卷信息
	//public void updatePaper(Map map);

	public PageInfo<Paper> findByPage(Integer pageNo,Integer pageSize);
}
