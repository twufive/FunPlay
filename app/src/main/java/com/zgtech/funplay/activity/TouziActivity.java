package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

/**
 * 投资详情
 * Created by Administrator on 2017/8/24.
 */

public class TouziActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touzi_detail);
        initData();
        initView();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
