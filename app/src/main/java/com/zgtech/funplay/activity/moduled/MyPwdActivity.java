package com.zgtech.funplay.activity.moduled;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的主页
 * Created by Administrator on 2017/8/14.
 */

public class MyPwdActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.et_pwd_origin)
    EditText etPwdOrigin;
    @Bind(R.id.et_pwd_new)
    EditText etPwdNew;
    @Bind(R.id.et_pwd_new_confirm)
    EditText etPwdNewConfirm;
    @Bind(R.id.btn_save)
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pwd);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("修改密码");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.btn_save:
                break;
        }
    }
}
