package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册第三页面
 * Created by Administrator on 2017/8/9.
 */

public class RegistCActivity extends BaseActivity {

    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.tv_age)
    TextView tvAge;
    @Bind(R.id.tv_height)
    TextView tvHeight;
    @Bind(R.id.tv_constellation)
    TextView tvConstellation;
    @Bind(R.id.btn_complete)
    Button btnComplete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_c);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("个人资料");

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.tv_sex, R.id.tv_age, R.id.tv_height, R.id.tv_constellation, R.id.btn_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                break;
            case R.id.tv_sex:
                break;
            case R.id.tv_age:
                break;
            case R.id.tv_height:
                break;
            case R.id.tv_constellation:
                break;
            case R.id.btn_complete:
                break;
        }
    }
}
