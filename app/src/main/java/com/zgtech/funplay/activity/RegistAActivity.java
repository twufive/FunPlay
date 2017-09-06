package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册第一页面
 * Created by Administrator on 2017/8/9.
 */

public class RegistAActivity extends BaseActivity {

    @Bind(R.id.et_mobile)
    EditText etMobile;
    @Bind(R.id.et_verify)
    EditText etVerify;
    @Bind(R.id.tv_get_verify)
    TextView tvGetVerify;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.btn_regist)
    Button btnRegist;
    @Bind(R.id.tv_protocol)
    TextView tvProtocol;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_a);
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

    @OnClick({R.id.tv_get_verify, R.id.btn_regist, R.id.tv_protocol})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_get_verify:
                break;
            case R.id.btn_regist:
                toNextActivity(RegistBActivity.class);
                break;
            case R.id.tv_protocol:
                break;
        }
    }
}
