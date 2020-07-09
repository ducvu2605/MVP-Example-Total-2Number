package com.example.mvpexample2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpexample2.Presenter.LoginContract;
import com.example.mvpexample2.Presenter.LoginPresenterImpl;
import com.example.mvpexample2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {
    @BindView(R.id.ed_id_name) EditText edIdName;
    @BindView(R.id.ed_password) EditText edPassword;
    @BindView(R.id.tv_show) TextView tvShow;
    @BindView(R.id.btn_click) Button btnClick;
    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new LoginPresenterImpl();
        setUpFindViewById();
        ButterKnife.bind(this);
        eventClick();
    }
    public void setUpFindViewById(){
//        edIdName = findViewById(R.id.ed_id_name);
//        edPassword = findViewById(R.id.ed_password);
//        tvShowTotal = findViewById(R.id.tv_show);
//        btnClick = findViewById(R.id.btn_click);
    }
    public void eventClick(){
        btnClick.setOnClickListener(this);
    }
    public void login(){
        String idName = edIdName.getText().toString().trim();
        String password = edPassword.getText().toString().trim();
        mPresenter.loginUser(idName,password);
    }
    @Override
    public void onClick(View view) {
        tvShow.setText("");
        login();
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
    public void onLoginSuccess() {
        Toast.makeText(this, "Login successful !", Toast.LENGTH_SHORT).show();
        tvShow.setText("Login Successfull !!!");
    }

    @Override
    public void onLoginFail(String error) {
        Toast.makeText(this, "Login failure !" + error, Toast.LENGTH_SHORT).show();
        tvShow.setText(error);
    }
}
