package com.zgtech.funplay.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.mine.MyCertifyActivity;
import com.zgtech.funplay.activity.mine.MyCollectActivity;
import com.zgtech.funplay.activity.mine.MyInfoActivity;
import com.zgtech.funplay.activity.mine.MyPageActivity;
import com.zgtech.funplay.activity.mine.MyPinTuanActivity;
import com.zgtech.funplay.activity.mine.MyPwdActivity;
import com.zgtech.funplay.activity.mine.MyReportActivity;
import com.zgtech.funplay.activity.mine.MySuggestActivity;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.utils.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人中心模块
 * Created by Administrator on 2017/8/1.
 */

public class MineFragment extends BaseFragment {
    @Bind(R.id.iv_avatar)
    ImageView ivAvatar;
    @Bind(R.id.tv_nick)
    TextView tvNick;
    @Bind(R.id.tv_sign)
    TextView tvSign;
    @Bind(R.id.tv_care)
    TextView tvCare;
    @Bind(R.id.tv_fans)
    TextView tvFans;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.appBar)
    AppBarLayout appBar;
    @Bind(R.id.rl_order)
    RelativeLayout rlOrder;
    @Bind(R.id.rl_info)
    RelativeLayout rlInfo;
    @Bind(R.id.rl_page)
    RelativeLayout rlPage;
    @Bind(R.id.rl_mine_collect)
    RelativeLayout rlMineCollect;
    @Bind(R.id.rl_mine_suggestion)
    RelativeLayout rlMineSuggestion;
    @Bind(R.id.rl_certify)
    RelativeLayout rlCertify;
    @Bind(R.id.rl_report)
    RelativeLayout rlReport;
    @Bind(R.id.rl_pwd)
    RelativeLayout rlPwd;
    @Bind(R.id.rl_logout)
    RelativeLayout rlLogout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);

        initData();
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i("MineFragment", "onDestroy");

    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initStatusBarState();
    }

    private void initStatusBarState() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = mActivity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void initData() {

    }

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }


    @OnClick({R.id.iv_avatar, R.id.tv_nick, R.id.tv_sign, R.id.tv_care, R.id.tv_fans, R.id.rl_order, R.id.rl_info, R.id.rl_page, R.id.rl_mine_collect, R.id.rl_mine_suggestion, R.id.rl_certify, R.id.rl_report, R.id.rl_pwd, R.id.rl_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_avatar:
                LogUtils.i("iv_avatar", "iv_avatar");
                break;
            case R.id.tv_nick:
                break;
            case R.id.tv_sign:
                break;
            case R.id.tv_care:
                break;
            case R.id.tv_fans:
                break;
            case R.id.rl_order:
                toNextActivity(MyPinTuanActivity.class);
                break;
            case R.id.rl_info:
                toNextActivity(MyInfoActivity.class);
                break;
            case R.id.rl_page:
                toNextActivity(MyPageActivity.class);
                break;
            case R.id.rl_mine_collect:
                toNextActivity(MyCollectActivity.class);
                break;
            case R.id.rl_mine_suggestion:
                toNextActivity(MySuggestActivity.class);
                break;
            case R.id.rl_certify:
                toNextActivity(MyCertifyActivity.class);
                break;
            case R.id.rl_report:
                toNextActivity(MyReportActivity.class);
                break;
            case R.id.rl_pwd:
                toNextActivity(MyPwdActivity.class);
                break;
            case R.id.rl_logout:
                break;
        }
    }
}
