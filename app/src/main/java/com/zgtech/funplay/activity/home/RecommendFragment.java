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

        RecommendModel individualModel = new RecommendModel();
        individualModel.setAvatarImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503315858704&di=eefd6e428c7f1aeb33b27144b939ede9&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F11%2F61%2F47%2F91b3OOOPIC66.jpg");
        individualModel.setSiteImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503315858704&di=eefd6e428c7f1aeb33b27144b939ede9&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F11%2F61%2F47%2F91b3OOOPIC66.jpg");
        individualModel.setSign("在这里，享受清风");
        individualModel.setReadCount("168");

        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
        recommendList.add(individualModel);
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }


}
