/**
 * 
 */
package com.example.test.entity;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 学生表
 */
public class Student
{
	/**学号*/
	private String stu_no;
	/**学生姓名*/
	private String stu_name;
	/**学生密码*/
	private String stu_pwd;
	/**学生专业*/
	private String stu_discipline;
	/**学生年级*/
	private String stu_grade;

	public String getStu_no() {
		return stu_no;
	}
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_pwd() {
		return stu_pwd;
	}
	public void setStu_pwd(String stu_pwd) { this.stu_pwd = stu_pwd; }
	public String getStu_discipline() {
		return stu_discipline;
	}
	public void setStu_discipline(String stu_discipline) { this.stu_discipline = stu_discipline; }
	public String getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(String stu_grade) {
		this.stu_grade = stu_grade;
	}

	public Student() {
		
	}
	
	
	public Student(String stu_no, String stu_name, String stu_pwd, String stu_discipline, String stu_grade) {
		super();
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_pwd = stu_pwd;
		this.stu_discipline = stu_discipline;
		this.stu_grade = stu_grade;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
