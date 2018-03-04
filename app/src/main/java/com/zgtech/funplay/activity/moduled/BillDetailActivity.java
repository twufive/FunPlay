package com.zgtech.funplay.activity.moduled;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 账单明细
 * Created by Administrator on 2017/8/14.
 */

public class BillDetailActivity extends BaseActivity {

    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;

    @Bind(R.id.tab_host)
    TabHost mTabHost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("账单明细");


    }

    @Override
    public void initData() {
        mTabHost.setup();
        mTabHost.addTab(mTabHost.newTabSpec("cost_history")
                .setIndicator("消费记录")//设置Tab标签和图标
                .setContent(R.id.tab1));
        mTabHost.addTab(mTabHost.newTabSpec("cash_history")
                .setIndicator("提现记录")//设置Tab标签和图标
                .setContent(R.id.tab2));
        mTabHost.addTab(mTabHost.newTabSpec("add_history")
                .setIndicator("收入记录")//设置Tab标签和图标
                .setContent(R.id.tab3));
    }

    @OnClick({R.id.ll_back, R.id.tv_toolbar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_toolbar:
                break;
        }
    }
}
