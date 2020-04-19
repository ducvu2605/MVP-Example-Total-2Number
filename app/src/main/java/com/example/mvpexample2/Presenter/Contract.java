package com.example.mvpexample2.Presenter;

public interface Contract {
    interface View {
        void showTotalNum1AndNum2(int total);
    }
    interface Presenter {
        void attachView(View view);
        void dropView();
        void getTotalNum1AndNum2(int numberOne,int numberTwo);

    }
}
