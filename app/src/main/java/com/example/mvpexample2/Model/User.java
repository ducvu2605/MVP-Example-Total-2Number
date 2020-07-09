package com.example.mvpexample2.Model;

import android.text.TextUtils;

import com.example.mvpexample2.Presenter.LoginContract;

public class User implements LoginContract.IUser {
    private String idName;
    private String passWord;

    public User(String idName, String passWord) {
        this.idName = idName;
        this.passWord = passWord;
    }

    @Override
    public String getIdName() {
        return idName;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public boolean isValidUser() {
        return !TextUtils.isEmpty(getIdName()) && getPassword().length() >= 3;
    }
}
