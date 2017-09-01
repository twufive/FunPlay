package com.zgtech.funplay.fragment.childFragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.NearbyAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.model.NearbyData;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 附近子模块
 * Created by Administrator on 2017/8/1.
 */

public class NearbyFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private NearbyAdapter nearbyAdapter;
    private List<NearbyData.ObjBean> originList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);
        ButterKnife.bind(this, view);

        initView(view, savedInstanceState);
        initData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.i("NearbyFragment", "onDestroy");
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
    }

    private void initNearBy(List<NearbyData.ObjBean> originList) {
        nearbyAdapter = new NearbyAdapter(mActivity, R.layout.fp_item_nearby, originList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mActivity, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(nearbyAdapter);
    }

    @Override
    protected void initData() {
//        NearbyData.ObjBean.setImgUrl("http://img4.imgtn.bdimg.com/it/u=3050884629,2611088519&fm=26&gp=0.jpg");
        HashMap map = new HashMap();
        map.put("cursor", "0");
        map.put("more", "false");
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.getNearbyData(body).enqueue(new Callback<NearbyData>() {
            @Override
            public void onResponse(Call<NearbyData> call, Response<NearbyData> response) {
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

            private void handleServerData(NearbyData model) {
                originList = model.getObj();
                initNearBy(originList);
            }

            @Override
            public void onFailure(Call<NearbyData> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }

    public static NearbyFragment newInstance() {
        NearbyFragment fragment = new NearbyFragment();
        return fragment;
    }

}
