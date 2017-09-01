package com.zgtech.funplay.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
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
        initStatusBarState();
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.btn_join)
    public void onViewClicked() {
        toNextActivity(TouziActivity.class);
    }

    private void initStatusBarState() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
