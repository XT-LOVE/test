package com.example.test.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.example.test.dao.PaperDao;
import com.example.test.entity.Paper;
import com.example.test.service.PaperService;
@Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	PaperDao paperDao;
	public List<Paper> find(int teacherId) {
		return paperDao.find(teacherId);
	}

	public Paper get(Serializable id) {
		return paperDao.get(id);
	}

	public int insert(Paper paper) {
		return paperDao.insert(paper);
	}

	public void update(Paper paper) {
		paperDao.update(paper);
	}

	public void delete(Serializable id) {
		paperDao.delete(id);
	}

	public void delete(Serializable[] ids) {
		paperDao.delete(ids);
	}

/*	public List<PapebyUserPaperById(Serializable id) {
		// TODO Auto-generated method stub
		return paperDao.getUserPaperById(id);
	}*/

	public String getProNo(Serializable paperId) {
		// TODO Auto-generated method stub
		return paperDao.getProNo(paperId);
	}

/*

	public List<Paper> getUndoPaper(Map map) {
		// TODO Auto-generated method stub
		return paperDao.getUndoPaper(map);
	}

	public List<Paper> qryUndoPaper(Map map) {
		// TODO Auto-generated method stub
		return paperDao.qryUndoPaper(map);
	}

*/
public PageInfo<Paper> findByPage(Integer pageNo,
									 Integer pageSize,Integer teacherId) {

	pageNo = pageNo == null?1:pageNo;
	pageSize = pageSize == null?10:pageSize;
	PageHelper.startPage(pageNo, pageSize);
	List<Paper> list = paperDao.find(teacherId);
	System.out.println(list.toString());
	//用PageInfo对结果进行包装
	PageInfo<Paper> pageInfo = new PageInfo<>(list);
	return pageInfo;
}

}
