package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录页面
 * Created by Administrator on 2017/8/9.
 */

public class LoginActivity extends BaseActivity {
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.tv_to_register)
    TextView tvToRegister;
    @Bind(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @Bind(R.id.et_mobile)
    EditText etMobile;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.rl_to_mobile_login)
    RelativeLayout rlToMobileLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_login, R.id.tv_to_register, R.id.tv_forget_pwd,R.id.rl_to_mobile_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                toNextActivityAndCloseThis(MainActivity.class);
                break;
            case R.id.tv_forget_pwd:
                toNextActivity(ForgetPwdActivity.class);
                break;
            case R.id.rl_to_mobile_login:
                toNextActivity(LoginSMSActivity.class);
                break;
            case R.id.tv_to_register:
                toNextActivity(RegistAActivity.class);
                break;
        }
    }
}
