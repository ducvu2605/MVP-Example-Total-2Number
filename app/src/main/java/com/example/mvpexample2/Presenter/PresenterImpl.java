package com.example.mvpexample2.Presenter;

import android.util.Log;

public class PresenterImpl implements Contract.Presenter {
    Contract.View mView;
    @Override
    public void attachView(Contract.View view) {
        this.mView = view;
    }

    @Override
    public void dropView() {
        this.mView =null;
    }

    @Override
    public void getTotalNum1AndNum2(int numberOne, int numberTwo) {
        int total = numberOne+numberTwo;
        Log.d("KiemTra",total+"");
        mView.showTotalNum1AndNum2(total);
    }


}
