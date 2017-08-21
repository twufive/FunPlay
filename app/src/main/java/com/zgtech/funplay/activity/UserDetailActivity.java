package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

/**
 * 核心页面：用户详情页
 * Created by Administrator on 2017/8/14.
 */

public class UserDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        initView();
        initData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
