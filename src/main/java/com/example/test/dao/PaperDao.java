package com.example.test.dao;

import java.util.List;
import java.util.Map;

import com.example.test.entity.Paper;
import com.example.test.entity.Question;

public interface PaperDao extends BaseDao<Paper> {

	//查看试卷详情
	public List<Question> getPaperDetail(Map map);
	
	//更新试卷信息
	public void updatePaper(Map map);
}
