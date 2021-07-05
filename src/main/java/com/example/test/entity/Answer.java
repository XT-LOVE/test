package com.example.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer {
    //答案编号
    @Id
    @Column(name = "ans_no")
    private int answerId;
    //答案内容
    @Column(name = "ans_detail")
    private String answerDetail;

    public Answer() {
    }
    public Answer(int answerId, String answerDetail) {
        this.answerId = answerId;
        this.answerDetail = answerDetail;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerDetail() {
        return answerDetail;
    }

    public void setAnswerDetail(String answerDetail) {
        this.answerDetail = answerDetail;
    }

    @Override
    public String toString() {
        return "answer{" +
                "answerId=" + answerId +
                ", answerDetail='" + answerDetail + '\'' +
                '}';
    }
}
