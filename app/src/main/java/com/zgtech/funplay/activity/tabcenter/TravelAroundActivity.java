package com.zgtech.funplay.activity.tabcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.fragment.childFragment.HotTravelAroundAdapter;
import com.zgtech.funplay.model.NewsModel;
import com.zgtech.funplay.model.RecommendOther3Model;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TravelAroundActivity extends BaseActivity {

    @Bind(R.id.rv_travel_around)
    RecyclerView rv;
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_right)
    ImageView ivRight;

    private HotTravelAroundAdapter newPersonAdapter;
    private List<RecommendOther3Model.ObjBean> originList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_around);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        llBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvToolbar.setText("结伴出游");
        ivRight.setVisibility(View.VISIBLE);
        ivRight.setImageResource(R.drawable.bg_add_photo);
    }

    private void initNewPerson(List<RecommendOther3Model.ObjBean> originList) {
        newPersonAdapter = new HotTravelAroundAdapter(this, R.layout.fp_item_hot_travel_around, originList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(newPersonAdapter);
    }


    @OnClick(R.id.tv_right)
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.tv_right:
                toNextActivity(PublishTravelAroundActivity.class);
                break;
        }
    }

    @Override
    public void initData() {

        newPersonAdapter = new HotTravelAroundAdapter(this, R.layout.fp_item_hot_travel_around, originList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(newPersonAdapter);
        newPersonAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                int viewId = originList.get(position).getUserId();
//                Intent intent = new Intent(TravelAroundActivity.this, NewsDetailActivity.class);
//                intent.putExtra("newsId", String.valueOf(viewId));
//                startActivity(intent);
            }
        });

        HashMap map = new HashMap();
        map.put("cursor", "0");
        map.put("more", "false");
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.getNewPersonData(body).enqueue(new Callback<RecommendOther3Model>() {
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
                initNewPerson(originList);
            }

            @Override
            public void onFailure(Call<RecommendOther3Model> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
