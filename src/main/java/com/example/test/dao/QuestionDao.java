package com.example.test.dao;

import java.util.List;

import com.example.test.entity.Question;
import org.apache.ibatis.annotations.Param;

public interface QuestionDao extends BaseDao<Question>{
    List<Question> createPaper(@Param("ch_no") List<String> ch_no,
                               @Param("type") List<String> type,
                               @Param("paperDif") int paperDif);
}
