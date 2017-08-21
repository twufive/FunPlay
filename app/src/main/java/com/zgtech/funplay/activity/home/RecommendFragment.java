package com.zgtech.funplay.activity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.RecommendAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.model.RecommendModel;
import com.zgtech.funplay.utils.LogUtils;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * 推荐子模块
 * Created by Administrator on 2017/8/1.
 */

public class RecommendFragment extends BaseFragment {
    private RecyclerView recyclerViewSite;
    private RecyclerView recyclerViewPerson;
    private RecommendAdapter recommendAdapterSite;
    private RecommendAdapter recommendAdapterPerson;
    private ArrayList<RecommendModel> recommendList;
    private LinearLayoutManager linearLayoutManagerSite;
    private LinearLayoutManager linearLayoutManagerPerson;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
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
        LogUtils.i("RecommendFragment", "onDestroy");
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initSite(view);
        initPerson(view);
    }

    private void initSite(View view) {
        recyclerViewSite = (RecyclerView) view.findViewById(R.id.recyclerview_site);
        recommendAdapterSite = new RecommendAdapter(mActivity, R.layout.fp_item_recommend, recommendList);
        linearLayoutManagerSite = new LinearLayoutManager(mActivity);
        linearLayoutManagerSite.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewSite.setLayoutManager(linearLayoutManagerSite);
        recyclerViewSite.setAdapter(recommendAdapterSite);

    }

    private void initPerson(View view) {
        recyclerViewPerson = (RecyclerView) view.findViewById(R.id.recyclerview_person);
        recommendAdapterPerson = new RecommendAdapter(mActivity, R.layout.fp_item_recommend, recommendList);
        linearLayoutManagerPerson = new LinearLayoutManager(mActivity);
        linearLayoutManagerPerson.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewPerson.setLayoutManager(linearLayoutManagerPerson);
        recyclerViewPerson.setAdapter(recommendAdapterPerson);
    }

    @Override
    protected void initData() {
        recommendList = new ArrayList<RecommendModel>();

        RecommendModel recommendModel = new RecommendModel();
        recommendModel.setAvatarImgUrl("http://img4.imgtn.bdimg.com/it/u=3050884629,2611088519&fm=26&gp=0.jpg");
//        newPersonModel.setSiteImgUrl("http://img4.imgtn.bdimg.com/it/u=3050884629,2611088519&fm=26&gp=0.jpg");
        recommendModel.setSiteImgUrl("http://img1.imgtn.bdimg.com/it/u=3703540791,4182251432&fm=26&gp=0.jpg");
        recommendModel.setSite("加拿大");
        recommendModel.setSign("在这里，享受清风");
        recommendModel.setReadCount("168");

        recommendList.add(recommendModel);
        recommendList.add(recommendModel);
        recommendList.add(recommendModel);
        recommendList.add(recommendModel);
        recommendList.add(recommendModel);
        recommendList.add(recommendModel);

    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }


}
