package com.example.test.domain;

public class Teacher {
    /**工号*/
    private String tea_no;
    /**教师名字*/
    private String tea_name;
    /**教师密码*/
    private String tea_pwd;
    /**教师专业*/
    private String tea_discipline;
    /**教师邮箱*/
    private String tea_mail;

    public String getTea_no() {
        return tea_no;
    }

    public void setTea_no(String tea_no) {
        this.tea_no = tea_no;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public String getTea_pwd() {
        return tea_pwd;
    }

    public void setTea_pwd(String tea_pwd) {
        this.tea_pwd = tea_pwd;
    }

    public String getTea_discipline() {
        return tea_discipline;
    }

    public void setTea_discipline(String tea_discipline) {
        this.tea_discipline = tea_discipline;
    }

    public String getTea_mail() {
        return tea_mail;
    }

    public void setTea_mail(String tea_mail) {
        this.tea_mail = tea_mail;
    }

    public Teacher() {
    }

    public Teacher(String tea_no, String tea_name, String tea_pwd, String tea_discipline, String tea_mail) {
        super();
        this.tea_no = tea_no;
        this.tea_name = tea_name;
        this.tea_pwd = tea_pwd;
        this.tea_discipline = tea_discipline;
        this.tea_mail = tea_mail;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
