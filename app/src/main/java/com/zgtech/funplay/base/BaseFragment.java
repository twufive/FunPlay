package com.zgtech.funplay.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.retrofit.RetrofitUtil;

/**
 * 基类Fragment
 * Created by Administrator on 2017/8/1.
 */

public abstract class BaseFragment extends Fragment {

    protected AppCompatActivity mActivity;
    public ApiStores mApiStores;

    /**
     * 获得全局的，防止使用getActivity()为空
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (AppCompatActivity) context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiStores = RetrofitUtil.initApiStores();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_base, container, false);
        initData();
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    /**
     * 该抽象方法就是 初始化view
     */
    protected abstract void initView(View view, Bundle savedInstanceState);

    /**
     * 执行数据的加载
     */
    protected abstract void initData();

    public void toNextActivity(Class targetActivityClass) {
        Intent intent = new Intent(getActivity(), targetActivityClass);
        startActivity(intent);
    }

}
