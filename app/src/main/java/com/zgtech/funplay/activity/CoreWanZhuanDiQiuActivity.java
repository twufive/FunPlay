package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 玩赚地球主页面
 * Created by Administrator on 2017/8/24.
 */

public class CoreWanZhuanDiQiuActivity extends BaseActivity {

    @Bind(R.id.btn_join)
    Button btnJoin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_diqiu);
        ButterKnife.bind(this);

        initData();
        initView();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.btn_join)
    public void onViewClicked() {
        toNextActivity(TouziActivity.class);
    }
}
