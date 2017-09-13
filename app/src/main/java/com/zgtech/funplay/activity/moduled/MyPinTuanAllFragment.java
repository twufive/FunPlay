package com.zgtech.funplay.activity.moduled;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.MyPinTuanAllAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.model.MyPinTuanModel;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 我的拼团，全部fragment
 * Created by Administrator on 2017/8/16.
 */

public class MyPinTuanAllFragment extends BaseFragment {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    private MyPinTuanAllAdapter adapter;
    private List<MyPinTuanModel.ObjBean> originList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pintuan_all, container, false);
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

    }

    @Override
    protected void initData() {
        mApiStores.getMyPinTuanData("0", "false").enqueue(new Callback<MyPinTuanModel>() {
            @Override
            public void onResponse(Call<MyPinTuanModel> call, Response<MyPinTuanModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode() == 2) {
                        handleServerData(response.body());
                    } else {
                        T.showShort(response.body().getMsg());
                    }
                } else {
                    T.showShort(response.toString());
                }
            }

            private void handleServerData(MyPinTuanModel model) {
                originList = model.getObj();
                initPinTuanAll(originList);
            }

            @Override
            public void onFailure(Call<MyPinTuanModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }

    private void initPinTuanAll(List<MyPinTuanModel.ObjBean> originList) {
        adapter = new MyPinTuanAllAdapter(mActivity, R.layout.fp_item_pintuan_all, originList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
    }

    public static MyPinTuanAllFragment newInstance() {
        MyPinTuanAllFragment fragment = new MyPinTuanAllFragment();
        return fragment;
    }

}
