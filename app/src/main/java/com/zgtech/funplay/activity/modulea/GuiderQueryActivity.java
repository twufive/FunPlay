package com.zgtech.funplay.activity.modulea;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.QueryGuiderAdapter;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.QueryGuiderModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 导游查询结果
 * Created by Administrator on 2017/9/13.
 */

public class GuiderQueryActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    private String title;

    private QueryGuiderAdapter queryGuiderAdapter;
    private List<QueryGuiderModel.ObjBean> originList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guider_query);
        ButterKnife.bind(this);

        title = getIntent().getExtras().getString("title", "");

        initView();
        initData();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("搜索结果");
    }

    private void initQueryGuider(List<QueryGuiderModel.ObjBean> originList) {
        queryGuiderAdapter = new QueryGuiderAdapter(GuiderQueryActivity.this, R.layout.fp_item_newperson, originList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GuiderQueryActivity.this);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(queryGuiderAdapter);
    }

    @Override
    public void initData() {
        searchTitle(title);
    }

    @OnClick(R.id.ll_back)
    public void onViewClicked() {
        finish();
    }

    private void searchTitle(String title) {
        HashMap map = new HashMap();
        map.put("cursor", 0);
        map.put("more", "false");
        map.put("title", "");
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.queryGuiderData(body).enqueue(new Callback<QueryGuiderModel>() {
            @Override
            public void onResponse(Call<QueryGuiderModel> call, Response<QueryGuiderModel> response) {
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

            private void handleServerData(QueryGuiderModel model) {
                originList= model.getObj();
                initQueryGuider(originList);
            }

            @Override
            public void onFailure(Call<QueryGuiderModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
