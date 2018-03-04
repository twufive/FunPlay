package com.zgtech.funplay.activity.moduled;

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
 * 我的主页
 * Created by Administrator on 2017/8/14.
 */

public class MyWalletActivity extends BaseActivity {

    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;

    @Bind(R.id.btn_wallet_cash)
    Button btnCash;

    @Bind(R.id.btn_wallet_add)
    Button btnAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("我的钱包");
    }

    @Override
    public void initData() {
    }

    @OnClick({R.id.ll_back, R.id.tv_toolbar,R.id.btn_wallet_cash,R.id.btn_wallet_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_toolbar:
                break;
            case R.id.btn_wallet_add:
                toNextActivity(WalletAddActivity.class);
                break;
            case R.id.btn_wallet_cash:
                toNextActivity(WalletCashActivity.class);
                break;
        }
    }
}