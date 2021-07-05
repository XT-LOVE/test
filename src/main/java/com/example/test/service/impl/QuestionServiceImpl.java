package com.example.test.service.impl;

import java.util.List;

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
	
	public List<Question> find(Question question) {
		return questionDao.find();
	}

	public Question get(int id) {
		return questionDao.get(id);
	}

	public void insert(Question question) {
		questionDao.insert(question);
	}

	public void update(Question question) {
		questionDao.update(question);
	}

	public void delete(int id) {
		questionDao.delete(id);
	}
	public List<Question> createPaper(List<String> ch_no, List<String> type, int paperDif){
		return  questionDao.createPaper(ch_no,type,paperDif);
	}

	public PageInfo<Question> findByPage(Question question, Integer pageNo,
			Integer pageSize) {
		
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Question> list = questionDao.find();
	    System.out.println(list.toString());
	    //用PageInfo对结果进行包装
	    PageInfo<Question> page = new PageInfo<Question>(list);
	    return page;
	}

}
