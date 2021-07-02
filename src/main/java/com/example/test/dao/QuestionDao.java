package com.example.test.dao;

import java.util.List;
import java.util.Map;

import com.example.test.entity.Paper;
import com.example.test.entity.Question;
import com.example.test.entity.Type;
import org.apache.ibatis.annotations.Param;

public interface QuestionDao extends BaseDao<Question>{
    public List<Question> createPaper(@Param("ch_no")List<Integer> ch_no,
                                      @Param("type")List<String> type,
                                      @Param("paperDif")int paperDif);
}
