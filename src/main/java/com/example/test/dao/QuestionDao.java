package com.example.test.dao;

import java.util.List;
import java.util.Map;

import com.example.test.entity.Paper;
import com.example.test.entity.Question;
import org.apache.ibatis.annotations.Param;

public interface QuestionDao extends BaseDao<Question>{
    public List<Question> createPaper(@Param("ch_no")Map ch_no,
                                      @Param("type")Map type,
                                      @Param("paperDif")int paperDif);
}
