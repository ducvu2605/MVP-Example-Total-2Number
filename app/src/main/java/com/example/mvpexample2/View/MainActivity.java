package com.example.mvpexample2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpexample2.Presenter.Contract;
import com.example.mvpexample2.Presenter.PresenterImpl;
import com.example.mvpexample2.R;

public class MainActivity extends AppCompatActivity implements Contract.View, View.OnClickListener {
    EditText edNum1,edNum2;
    TextView tvShowTotal;
    Button btnClick;

    Contract.Presenter mPresenter;
    int numberOne , numberTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new PresenterImpl();
        setUpFindViewById();
        eventClick();
    }
    public void setUpFindViewById(){
        edNum1 = findViewById(R.id.ed_name);
        edNum2 = findViewById(R.id.ed_id);
        tvShowTotal = findViewById(R.id.tv_show);
        btnClick = findViewById(R.id.btn_click);
    }
    public void eventClick(){
        btnClick.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        numberOne = Integer.parseInt(edNum1.getText().toString());
        numberTwo = Integer.parseInt(edNum2.getText().toString());
        mPresenter.getTotalNum1AndNum2(numberOne,numberTwo);
    }
    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attachView(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }
    @Override
    public void showTotalNum1AndNum2(int total) {
        tvShowTotal.setText(total+"");
        Toast.makeText(this,"Đã truyền được dữ liệu tổng 2 số là "+total,Toast.LENGTH_SHORT).show();
    }
}
