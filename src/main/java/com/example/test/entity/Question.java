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
	private int pro_no;
	//习题内容
	@Column(name = "pro_detail")
	private String quesDetail;
	//习题答案编号
	@Column(name = "pro_ansno")
	private int answerId;
	//关键字
	@Column(name = "pro_keyw")
	private String keyword;
	//难度系数
	@Column(name = "pro_dif")
	private int questionDif;
	//所属章节编号
	@Column(name = "char_no")
	private int ch;
	//所属章节标题
	@Column(name = "char_title")
	private String chTitle;
	//所属章节要点
	@Column(name = "char_mpoint")
	private String chMPoint;
	//习题类型
	@Column(name = "pro_type")
	private String questionType;

	public Question() {
	}
	public Question(int pro_no, String quesDetail, int answerId, String keyword, int questionDif,
					int ch, String chTitle, String chMPoint, String questionType) {
		this.pro_no = pro_no;
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
		return pro_no;
	}

	public String getQuesDetail() {
		return quesDetail;
	}

	public void setQuestionId(int pro_no) {
		this.pro_no = pro_no;
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

	@Override
	public String toString() {
		return "Question{" +
				"pro_no=" + pro_no +
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
