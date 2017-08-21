package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.PinTuanAllAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.model.PinTuanAllModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * TA的故事，fragment
 * Created by Administrator on 2017/8/16.
 */

public class TaStoryFragment extends BaseFragment {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    private PinTuanAllAdapter adapter;
    private ArrayList<PinTuanAllModel> originList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pintuan_all, container, false);
//        View view = inflater.inflate(R.layout.test, container, false);
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
    protected void initView(View view, Bundle savedInstanceState) {


        adapter = new PinTuanAllAdapter(mActivity, R.layout.fp_item_pintuan_all, originList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        originList = new ArrayList<PinTuanAllModel>();

        PinTuanAllModel pinTuanAllModel = new PinTuanAllModel();
        pinTuanAllModel.setSiteUrl("http://img1.imgtn.bdimg.com/it/u=3703540791,4182251432&fm=26&gp=0.jpg");
        pinTuanAllModel.setState("已完成");
        pinTuanAllModel.setPrice("90");
        pinTuanAllModel.setTime("2017-08-16 19:37");
        pinTuanAllModel.setTitle("桃花仑三日游");

        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
        originList.add(pinTuanAllModel);
    }

    public static TaStoryFragment newInstance() {
        TaStoryFragment fragment = new TaStoryFragment();
        return fragment;
    }

}
