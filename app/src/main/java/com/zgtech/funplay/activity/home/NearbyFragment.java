package com.zgtech.funplay.activity.home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.NearbyAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.model.NearbyModel;
import com.zgtech.funplay.utils.LogUtils;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * 附近子模块
 * Created by Administrator on 2017/8/1.
 */

public class NearbyFragment extends BaseFragment {
    private NearbyAdapter nearbyAdapter;
    private RecyclerView recyclerView;
    private ArrayList<NearbyModel> nearbyList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);
        ButterKnife.bind(this, view);

        initData();
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i("NearbyFragment", "onDestroy");
    }



    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);


        nearbyAdapter = new NearbyAdapter(mActivity,R.layout.fp_item_nearby, nearbyList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mActivity, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(nearbyAdapter);
    }

    @Override
    protected void initData() {
        nearbyList = new ArrayList<NearbyModel>();

        NearbyModel nearbyModel = new NearbyModel();
        nearbyModel.setImgUrl("http://img4.imgtn.bdimg.com/it/u=3050884629,2611088519&fm=26&gp=0.jpg");
        nearbyModel.setNick("Summer");
        nearbyModel.setPrice("100");

        nearbyList.add(nearbyModel);
        nearbyList.add(nearbyModel);
        nearbyList.add(nearbyModel);
        nearbyList.add(nearbyModel);
        nearbyList.add(nearbyModel);
        nearbyList.add(nearbyModel);
        nearbyList.add(nearbyModel);
        nearbyList.add(nearbyModel);
    }

    public static NearbyFragment newInstance() {
        NearbyFragment fragment = new NearbyFragment();
        return fragment;
    }

}
