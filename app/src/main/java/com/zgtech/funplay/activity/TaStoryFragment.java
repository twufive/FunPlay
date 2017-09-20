package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.TaStoryAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.model.UserDetailModel;
import com.zgtech.funplay.utils.SPUtils;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * TA的故事，fragment
 * Created by Administrator on 2017/8/16.
 */

public class TaStoryFragment extends BaseFragment {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    private TaStoryAdapter adapter;
    private List<UserDetailModel.ObjBean.SpacesBean> originList = new ArrayList<>();
    private String otherUserId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pintuan_all, container, false);
        ButterKnife.bind(this, view);

        otherUserId = SPUtils.getString(mActivity,"otherUserId","");

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
        mApiStores.getUserDetailData(otherUserId).enqueue(new Callback<UserDetailModel>() {
            @Override
            public void onResponse(Call<UserDetailModel> call, Response<UserDetailModel> response) {
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

            private void handleServerData(UserDetailModel model) {
                originList = model.getObj().getSpaces();
                initTaStory(originList);
            }

            @Override
            public void onFailure(Call<UserDetailModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }

    private void initTaStory(List<UserDetailModel.ObjBean.SpacesBean> originList) {
        adapter = new TaStoryAdapter(mActivity, R.layout.fp_item_social_main_ta_story, originList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
    }

    public static TaStoryFragment newInstance() {
        TaStoryFragment fragment = new TaStoryFragment();
        return fragment;
    }

}
