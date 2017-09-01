package com.zgtech.funplay.fragment.childFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.RecommendPersonAdapter;
import com.zgtech.funplay.adapter.RecommendSiteAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.model.RecommendModel;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 推荐子模块
 * Created by Administrator on 2017/8/1.
 */

public class RecommendFragment extends BaseFragment {
    private RecyclerView recyclerViewSite;
    private RecyclerView recyclerViewPerson;
    private LinearLayoutManager linearLayoutManagerSite;
    private LinearLayoutManager linearLayoutManagerPerson;

    private RecommendSiteAdapter siteAdapter;
    private RecommendPersonAdapter personAdapter;

    private List<RecommendModel.ObjBean.AddressListBean> addressList = new ArrayList<>();
    private List<RecommendModel.ObjBean.FoodListBean> foodList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View thisView = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, thisView);

        initView(thisView, savedInstanceState);
        initData();
        return thisView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.i("RecommendFragment", "onDestroy");
    }

    @Override
    protected void initView(View thisView, Bundle savedInstanceState) {
        recyclerViewSite = (RecyclerView) thisView.findViewById(R.id.recyclerview_site);
        recyclerViewPerson = (RecyclerView) thisView.findViewById(R.id.recyclerview_person);
    }

    @Override
    protected void initData() {
        mApiStores.getRecommendData().enqueue(new Callback<RecommendModel>() {
            @Override
            public void onResponse(Call<RecommendModel> call, Response<RecommendModel> response) {
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

            private void handleServerData(RecommendModel model) {
                addressList = model.getObj().getAddressList();
                foodList = model.getObj().getFoodList();

                initSite();
                initPerson();
            }

            @Override
            public void onFailure(Call<RecommendModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }


    private void initSite() {
        siteAdapter = new RecommendSiteAdapter(mActivity, R.layout.fp_item_recommend, addressList);
        linearLayoutManagerSite = new LinearLayoutManager(mActivity);
        linearLayoutManagerSite.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewSite.setLayoutManager(linearLayoutManagerSite);
        recyclerViewSite.setAdapter(siteAdapter);
    }

    private void initPerson() {
        personAdapter = new RecommendPersonAdapter(mActivity, R.layout.fp_item_recommend, foodList);
        linearLayoutManagerPerson = new LinearLayoutManager(mActivity);
        linearLayoutManagerPerson.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewPerson.setLayoutManager(linearLayoutManagerPerson);
        recyclerViewPerson.setAdapter(personAdapter);
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }
}
