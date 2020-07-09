package com.example.mvpexample2.Presenter;

import com.example.mvpexample2.Model.User;

public interface LoginContract {
    interface View {
        void onLoginSuccess();
        void onLoginFail(String error);
    }
    interface Presenter {
        void attachView(View view);
        void dropView();
        void loginUser(String idName ,String password);
    }

}
