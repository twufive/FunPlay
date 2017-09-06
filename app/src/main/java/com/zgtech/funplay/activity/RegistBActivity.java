package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册第二页面
 * Created by Administrator on 2017/8/9.
 */

public class RegistBActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_avatar)
    ImageView ivAvatar;
    @Bind(R.id.et_nick)
    EditText etNick;
    @Bind(R.id.et_wx_user)
    EditText etWxUser;
    @Bind(R.id.et_vocation)
    EditText etVocation;
    @Bind(R.id.btn_next)
    Button btnNext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_b);
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

    @OnClick({R.id.ll_back, R.id.iv_avatar, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.iv_avatar:
                break;
            case R.id.btn_next:
                toNextActivity(RegistCActivity.class);
                break;
        }
    }

}
