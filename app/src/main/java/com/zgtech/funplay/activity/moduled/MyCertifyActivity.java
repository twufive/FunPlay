package com.zgtech.funplay.activity.moduled;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.utils.SP;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的主页
 * Created by Administrator on 2017/8/14.
 */

public class MyCertifyActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_certify_idcard)
    ImageView ivCertifyIdcard;
    @Bind(R.id.tv_certify_idcard)
    TextView tvCertifyIdcard;
    @Bind(R.id.ll_scenic_card)
    CardView cardIdcard;
    @Bind(R.id.iv_certify_profession)
    ImageView ivCertifyProfession;
    @Bind(R.id.tv_certify_profession)
    TextView tvCertifyProfession;
    @Bind(R.id.card_profession)
    CardView cardProfession;
    private String stateIdent;
    private String stateIdentJob;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_certify);
        ButterKnife.bind(this);

        stateIdent = SP.getString(this, "stateIdent", "");
        stateIdentJob = SP.getString(this, "stateIdentJob", "");

        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("个人认证");

        tvCertifyIdcard.setText(stateIdent);
        tvCertifyProfession.setText(stateIdentJob);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.tv_toolbar, R.id.ll_scenic_card, R.id.card_profession})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_toolbar:
                break;
            case R.id.ll_scenic_card:
                if (stateIdent.equals("未认证")) {
                    toNextActivity(CertifyIDActivity.class);
                }
                break;
            case R.id.card_profession:
                if (stateIdentJob.equals("未认证")) {
                    toNextActivity(CertifyVocationActivity.class);
                }
                break;
        }
    }
}
