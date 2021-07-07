package com.example.test.dao;

import java.util.List;
import java.util.Map;

import com.example.test.entity.Question;
import org.apache.ibatis.annotations.Param;

public interface QuestionDao extends BaseDao<Question>{
    List<Question> createPaper(Map map);
}
