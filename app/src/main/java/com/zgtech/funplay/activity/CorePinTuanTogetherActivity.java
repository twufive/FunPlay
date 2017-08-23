package com.zgtech.funplay.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.View;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 立即拼团 页面
 * Created by Administrator on 2017/8/14.
 */

public class CorePinTuanTogetherActivity extends BaseActivity {
    @Bind(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_pintuan_detail);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
//        llBack.setVisibility(View.VISIBLE);
//        tvToolbar.setText("我的主页");

        initStatusBarState();
    }

    @Override
    public void initData() {

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
