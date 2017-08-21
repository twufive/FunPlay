package com.zgtech.funplay.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.utils.LogUtils;

import butterknife.ButterKnife;

/**
 * 旅游圈模块
 * Created by Administrator on 2017/8/1.
 */

public class FindFragment extends BaseFragment {
//    @Bind(R.id.tv_toolbar)
//    TextView tvToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        ButterKnife.bind(this, view);

        initData();
        initView(view, savedInstanceState);
        return view;
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
//        tvToolbar.setText("旅游圈");
        initStausBar();
    }

    private void initStausBar() {
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

    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i("FindFragment", "onDestroy");
    }
}
