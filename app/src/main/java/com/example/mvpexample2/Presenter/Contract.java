package com.example.mvpexample2.Presenter;

public interface Contract {
    interface View {
        void showTotalTwoNumber(int total);
    }
    interface Presenter {
        void attachView(View view);
        void dropView();
        void calculatorSumTwoNumber(int numberOne,int numberTwo);

    }
}
