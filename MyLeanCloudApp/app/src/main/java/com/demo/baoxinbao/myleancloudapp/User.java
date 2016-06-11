package com.demo.baoxinbao.myleancloudapp;

/**
 * Created by baoxinbao on 6/11.
 */
public class User {
    private int userId;
    private String userName;
    private String passWord;
    private String eMail;

    public User(int userId, String userName, String passWord, String eMail) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.eMail = eMail;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord, String eMail) {
        this.userName = userName;
        this.passWord = passWord;
        this.eMail = eMail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
