package com.example.mvpexample2.Model;

public class User {
    private String idName;
    private String passWord;

    public User() {
    }

    public User(String idName, String passWord) {
        this.idName = idName;
        this.passWord = passWord;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
