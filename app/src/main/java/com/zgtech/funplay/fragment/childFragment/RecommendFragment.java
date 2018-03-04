package com.zgtech.funplay.fragment.childFragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.HomeQualityFoodAdapter;
import com.zgtech.funplay.adapter.HomeQualityScenicAdapter;
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
    private RecyclerView recyclerViewScenic;
    private RecyclerView recyclerViewFood;

    private HomeQualityScenicAdapter scenicAdapter;
    private HomeQualityFoodAdapter foodAdapter;

    private List<RecommendModel.ObjBean.AddressListBean> scenicList = new ArrayList<>();
    private List<RecommendModel.ObjBean.FoodListBean> foodList = new ArrayList<>();
    private ProgressDialog dialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View thisView = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, thisView);

        showProgressDialog();

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
        recyclerViewScenic = (RecyclerView) thisView.findViewById(R.id.recyclerview_site);
        recyclerViewFood = (RecyclerView) thisView.findViewById(R.id.recyclerview_person);
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
                scenicList = model.getObj().getAddressList();
                foodList = model.getObj().getFoodList();

                // 拼装 更多
                RecommendModel.ObjBean.AddressListBean addressListBean = new RecommendModel.ObjBean.AddressListBean();
                addressListBean.setOrderTitle("更多");
                addressListBean.setCommentCount(-1);
                addressListBean.setOrderPicture1(scenicList.get(0).getOrderPicture1());
                scenicList.add(addressListBean);

                RecommendModel.ObjBean.FoodListBean foodListBean = new RecommendModel.ObjBean.FoodListBean();
                foodListBean.setOrderTitle("更多");
                foodListBean.setCommentCount(-1);
                foodListBean.setOrderPicture1(foodList.get(0).getOrderPicture1());
                foodList.add(foodListBean);

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
        scenicAdapter = new HomeQualityScenicAdapter(mActivity, R.layout.fp_item_recommend, scenicList);
        LinearLayoutManager linearLayoutManagerSite = new LinearLayoutManager(mActivity);
        linearLayoutManagerSite.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewScenic.setLayoutManager(linearLayoutManagerSite);
        recyclerViewScenic.setAdapter(scenicAdapter);
        dialog.dismiss();
    }

    private void initPerson() {
        foodAdapter = new HomeQualityFoodAdapter(mActivity, R.layout.fp_item_recommend, foodList);
        LinearLayoutManager linearLayoutManagerPerson = new LinearLayoutManager(mActivity);
        linearLayoutManagerPerson.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewFood.setLayoutManager(linearLayoutManagerPerson);
        recyclerViewFood.setAdapter(foodAdapter);
    }

    private void showProgressDialog() {
        dialog = new ProgressDialog(mActivity);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在加载...");
        dialog.show();
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }
}
