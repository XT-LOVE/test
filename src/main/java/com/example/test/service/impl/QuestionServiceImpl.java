package com.example.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.example.test.dao.QuestionDao;
import com.example.test.entity.Question;
import com.example.test.service.QuestionService;
@Service("QuestionService")
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public List<Question> find() {
		return questionDao.find();
	}

	public Question get(int id) {
		return questionDao.get(id);
	}

	public void insert(Question question) {
		questionDao.insert(question);
	}

	public int update(Question question) {
		return questionDao.update(question);
	}

	public int delete(int id) {
		return questionDao.delete(id);
	}
	public List<Question> createPaper(List<String> ch_no, List<String> type, int paperDif, int problemNum){
		Map map = new HashMap();
		map.put("ch_no",ch_no);
		map.put("type",type);
		map.put("paperDif",paperDif);
		map.put("problemNum",problemNum);
		return  questionDao.createPaper(map);
	}

	public PageInfo<Question> findByPage(Integer pageNo,
			Integer pageSize) {
		
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Question> list = questionDao.find();
	    System.out.println(list.toString());
	    //用PageInfo对结果进行包装
		PageInfo<Question> pageInfo = new PageInfo<>(list);
	    return pageInfo;
	}

}
