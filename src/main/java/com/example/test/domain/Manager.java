package com.example.test.domain;

public class Manager {
    /**账号*/
    private String mana_no;
    /**管理员名字*/
    private String mana_name;
    /**管理员密码*/
    private String mana_pwd;

    public String getMana_no() {
        return mana_no;
    }

    public void setMana_no(String mana_no) {
        this.mana_no = mana_no;
    }

    public String getMana_name() {
        return mana_name;
    }

    public void setMana_name(String mana_name) {
        this.mana_name = mana_name;
    }

    public String getMana_pwd() {
        return mana_pwd;
    }

    public void setMana_pwd(String mana_pwd) {
        this.mana_pwd = mana_pwd;
    }

    public Manager() {
    }

    public Manager(String mana_no, String mana_name, String mana_pwd) {
        super();
        this.mana_no = mana_no;
        this.mana_name = mana_name;
        this.mana_pwd = mana_pwd;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
