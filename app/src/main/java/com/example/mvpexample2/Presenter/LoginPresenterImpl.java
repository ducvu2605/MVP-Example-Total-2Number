package com.example.mvpexample2.Presenter;

import com.example.mvpexample2.Model.User;

public class LoginPresenterImpl implements LoginContract.Presenter {
    private LoginContract.View mView;
    private User user;

    @Override
    public void attachView(LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void dropView() {
        this.mView = null;
    }

    @Override
    public void loginUser(String idName, String password) {
        User user = new User(idName , password);
        boolean isLoginSuccess = user.isValidUser();
        if (user.getIdName().equals("Vudeptrai") && user.getPassword().equals("123")) {
            // Login success
            mView.onLoginSuccess();

        }
        else {
            // fail
            mView.onLoginFail("idName or Password not true !!! ");
        }
    }

}
