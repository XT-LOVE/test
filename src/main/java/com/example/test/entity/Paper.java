package com.example.test.entity;
/**
 * 试卷实体
 * @author hspcadmin
 *
 */
public class Paper {
	//试卷编号
	private String paperId;
	//试卷名称
	private String paperName;
	//创建时间
	private String createTime;
	//试卷类型
	private String paperType;
	//试卷难度
	private int paperDif;
	//试题数量
	private int problemNum;
	//试卷分数
	private String score;
	//试卷内容
	private String paperDetail;
	//试卷负责人
	private int teacherId;

	public Paper() {

	}

	public Paper(String paperId, String paperName, String createTime, String paperType, int paperDif,
				 int problemNum, String score, String paperDetail, int teacherId) {
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

	public String getPaperDetail() {
		return paperDetail;
	}

	public void setPaperDetail(String paperDetail) {
		this.paperDetail = paperDetail;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
/*
	@Override
	public String toString() {
		return "Paper [paperId=" + paperId + ", paperName=" + paperName
				+ ", courseId=" + courseId + ", gradeId=" + gradeId
				+ ", userId=" + userId + ", questionId=" + questionId
				+ ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", allowTime=" + allowTime + ", score=" + score
				+ ", paperstate=" + paperState + "]";
	}*/

}
