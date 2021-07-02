package com.example.test.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="test")
public class Paper {
	//试卷编号
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tst_no", nullable = false)
	private String paperId;
	//试卷名称
	@Column(name = "tst_name")
	private String paperName;
	//创建时间
	@Column(name = "tst_time")
	private String createTime;
	//试卷类型
	@Column(name = "tst_type")
	private String paperType;
	//试卷难度
	@Column(name = "tst_dif")
	private int paperDif;
	//试题数量
	@Column(name = "tst_num")
	private int problemNum;
	//试卷分数
	@Column(name = "tst_score")
	private String score;
	//试卷内容
	@OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.LAZY,targetEntity=Question.class)
	@JoinColumn(name="pro_no")
	private List<Question> paperDetail = new ArrayList<>();
	//试卷负责人
	@Column(name = "tst_tea")
	private int teacherId;
	@Column(name = "pro_no")
	private String questionId;


/*//所属章节

	@OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.LAZY,targetEntity=Integer)
	private Set<Integer> ch = new HashSet<>();*/

	public Paper() {

	}

	public Paper(String paperId, String paperName, String createTime, String paperType, int paperDif,
				 int problemNum, String score, List<Question> paperDetail, int teacherId) {
		this.paperId = paperId;
		this.paperName = paperName;
		this.createTime = createTime;
		this.paperType = paperType;
		this.paperDif = paperDif;
		this.problemNum = problemNum;
		this.score = score;
		this.paperDetail = paperDetail;
		this.teacherId = teacherId;
	}

	//getter and setter
	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public int getPaperDif() {
		return paperDif;
	}

	public void setPaperDif(int paperDif) {
		this.paperDif = paperDif;
	}

	public int getProblemNum() {
		return problemNum;
	}

	public void setProblemNum(int problemNum) {
		this.problemNum = problemNum;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public List<Question> getPaperDetail() {
		return paperDetail;
	}

	public void setPaperDetail(List<Question> paperDetail) {
		this.paperDetail = paperDetail;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	/*public int getCh() {
            return ch;
        }

        public void setCh(int ch) {
            this.ch = ch;
        }*/
	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	@Override
	public String toString() {
		return "Paper{" +
				"paperId='" + paperId + '\'' +
				", paperName='" + paperName + '\'' +
				", createTime='" + createTime + '\'' +
				", paperType='" + paperType + '\'' +
				", paperDif=" + paperDif +
				", problemNum=" + problemNum +
				", score='" + score + '\'' +
				", paperDetail='" + paperDetail + '\'' +
				", teacherId=" + teacherId +
				'}';
	}
}
