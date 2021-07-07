package com.example.test.dao;

import com.example.test.entity.Paper;

import java.io.Serializable;

public interface PaperDao extends BaseDao<Paper> {

	//查看试卷详情
	public String getProNo(Serializable paperId);
	
	//更新试卷信息
	//public void updatePaper(Map map);
}
