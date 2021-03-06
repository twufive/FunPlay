package com.zgtech.funplay.fragment.childFragment;

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
import com.zgtech.funplay.model.RecommendOther3Model;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 已认证子模块
 *
 * 已废弃
 * Created by Administrator on 2017/8/1.
 */

public class CertifyFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private NewPersonAdapter newPersonAdapter;
    private List<RecommendOther3Model.ObjBean> originList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_certify, container, false);
        ButterKnife.bind(this, view);

        initView(view, savedInstanceState);
        initData();
        return view;
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
    }

    private void initCertify(List<RecommendOther3Model.ObjBean> originList) {
        newPersonAdapter = new NewPersonAdapter(mActivity, R.layout.fp_item_newperson, originList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(newPersonAdapter);
    }

    @Override
    protected void initData() {
        HashMap map = new HashMap();
        map.put("cursor", "0");
        map.put("more", "false");
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.getCertifyData(body).enqueue(new Callback<RecommendOther3Model>() {
            @Override
            public void onResponse(Call<RecommendOther3Model> call, Response<RecommendOther3Model> response) {
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

            private void handleServerData(RecommendOther3Model model) {
                originList = model.getObj();
                Iterator<RecommendOther3Model.ObjBean> iterator = originList.iterator();//此处删除没有订单的用户展示数据源
                while(iterator.hasNext()){
                    RecommendOther3Model.ObjBean individualModel = iterator.next();
                    if(individualModel.getOrders() == null || individualModel.getOrders().size() == 0){
                        iterator.remove();
                    }
                }
                initCertify(originList);
            }

            @Override
            public void onFailure(Call<RecommendOther3Model> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }

    public static CertifyFragment newInstance() {
        CertifyFragment fragment = new CertifyFragment();
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.i("CertifyFragment", "onDestroy");
    }
}
