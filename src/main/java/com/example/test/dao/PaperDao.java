package com.example.test.dao;

import com.example.test.entity.Paper;

import java.io.Serializable;
import java.util.List;

public interface PaperDao extends BaseDao<Paper> {
	public List<Paper> find(int teacherId);

	//查看试卷详情
	public String getProNo(Serializable paperId);
	
	//更新试卷信息
	//public void updatePaper(Map map);
}
