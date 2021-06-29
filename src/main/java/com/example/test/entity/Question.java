package com.example.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="problem")
public class Question {
	//习题编号
	@Id
	@Column(name = "pro_no")
	private int questionId;
	//习题内容
	@Column(name = "pro_detail")
	private String quesDetail;
	//习题答案编号
	@Column(name = "pro_ansno")
	private int answerId;
	//关键字
	private String keyword;
	//难度系数
	private int questionDif;
	//所属章节编号
	private int ch;
	//所属章节标题
	private String chTitle;

	public Question() {
	}
	public Question(int questionId, String quesDetail, int answerId, String keyword, int questionDif,
					int ch, String chTitle, String chMPoint, String questionType) {
		this.questionId = questionId;
		this.quesDetail = quesDetail;
		this.answerId = answerId;
		this.keyword = keyword;
		this.questionDif = questionDif;
		this.ch = ch;
		this.chTitle = chTitle;
		this.chMPoint = chMPoint;
		this.questionType = questionType;
	}

	//getter & setter
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuesName() {
		return quesDetail;
	}

	public void setQuesDetail(String quesDetail) {
		this.quesDetail = quesDetail;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getQuestionDif() {
		return questionDif;
	}

	public void setQuestionDif(int questionDif) {
		this.questionDif = questionDif;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public String getChTitle() {
		return chTitle;
	}

	public void setChTitle(String chTitle) {
		this.chTitle = chTitle;
	}

	public String getChMPoint() {
		return chMPoint;
	}

	public void setChMPoint(String chMPoint) {
		this.chMPoint = chMPoint;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	//所属章节要点
	private String chMPoint;
	//习题类型
	private String questionType;

	@Override
	public String toString() {
		return "Question{" +
				"questionId=" + questionId +
				", quesDetail='" + quesDetail + '\'' +
				", answerId=" + answerId +
				", keyword='" + keyword + '\'' +
				", questionDif=" + questionDif +
				", ch=" + ch +
				", chTitle='" + chTitle + '\'' +
				", chMPoint='" + chMPoint + '\'' +
				", questionType='" + questionType + '\'' +
				'}';
	}
}
