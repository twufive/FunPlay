package com.zgtech.funplay.activity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.NewPersonAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.model.NewPersonModel;
import com.zgtech.funplay.utils.LogUtils;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * 新人子模块
 * Created by Administrator on 2017/8/1.
 */

public class NewPersonFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private NewPersonAdapter newPersonAdapter;
    private ArrayList<NewPersonModel> newPersonList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newperson, container, false);
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
        LogUtils.i("NewPersonFragment", "onDestroy");
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        newPersonAdapter = new NewPersonAdapter(mActivity, R.layout.fp_item_newperson, newPersonList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(newPersonAdapter);
    }

    @Override
    protected void initData() {
        newPersonList = new ArrayList<NewPersonModel>();

        NewPersonModel newPersonModel = new NewPersonModel();
        newPersonModel.setAvatarImgUrl("http://img4.imgtn.bdimg.com/it/u=3050884629,2611088519&fm=26&gp=0.jpg");
//        newPersonModel.setSiteImgUrl("http://img4.imgtn.bdimg.com/it/u=3050884629,2611088519&fm=26&gp=0.jpg");
        newPersonModel.setSiteImgUrl("http://img1.imgtn.bdimg.com/it/u=3703540791,4182251432&fm=26&gp=0.jpg");
        newPersonModel.setNick("奕欢");
        newPersonModel.setDeal("20");
        newPersonModel.setScore("5");
        newPersonModel.setPrice("100");

        newPersonList.add(newPersonModel);
        newPersonList.add(newPersonModel);
        newPersonList.add(newPersonModel);
        newPersonList.add(newPersonModel);
        newPersonList.add(newPersonModel);
        newPersonList.add(newPersonModel);
    }

    public static NewPersonFragment newInstance() {
        NewPersonFragment fragment = new NewPersonFragment();
        return fragment;
    }

}
