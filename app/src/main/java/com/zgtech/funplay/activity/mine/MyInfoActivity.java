package com.zgtech.funplay.activity.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的资料页面
 * Created by Administrator on 2017/8/14.
 */

public class MyInfoActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_avatar)
    ImageView ivAvatar;
    @Bind(R.id.rl_avatar)
    RelativeLayout rlAvatar;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.rl_sex)
    RelativeLayout rlSex;
    @Bind(R.id.tv_stature)
    TextView tvStature;
    @Bind(R.id.rl_stature)
    RelativeLayout rlStature;
    @Bind(R.id.tv_age)
    TextView tvAge;
    @Bind(R.id.rl_age)
    RelativeLayout rlAge;
    @Bind(R.id.tv_constellation)
    TextView tvConstellation;
    @Bind(R.id.rl_constellation)
    RelativeLayout rlConstellation;
    @Bind(R.id.rl_bg_pic)
    RelativeLayout rlBgPic;
    @Bind(R.id.rl_introduce)
    RelativeLayout rlIntroduce;
    @Bind(R.id.et_introduce)
    EditText etIntroduce;
    @Bind(R.id.btn_save)
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("我的资料");


    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.rl_avatar, R.id.rl_sex, R.id.rl_stature, R.id.rl_age, R.id.rl_constellation, R.id.rl_bg_pic, R.id.rl_introduce,R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.rl_avatar:
                break;
            case R.id.rl_sex:
                break;
            case R.id.rl_stature:
                break;
            case R.id.rl_age:
                break;
            case R.id.rl_constellation:
                break;
            case R.id.rl_bg_pic:
                break;
            case R.id.rl_introduce:
                break;
            case R.id.btn_save:
                break;
        }
    }

}
