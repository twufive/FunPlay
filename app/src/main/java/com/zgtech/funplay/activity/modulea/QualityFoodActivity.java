package com.zgtech.funplay.activity.modulea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.QualityFoodModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QualityFoodActivity extends BaseActivity {

    @Bind(R.id.rv_quality_food)
    RecyclerView rv;
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;

    List<QualityFoodModel.ListBean> foodList = new ArrayList<>();
    QualityFoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_food);
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
        tvToolbar.setText("精华景点");
    }

    @Override
    public void initData() {

        LinearLayoutManager linearLayoutManagerSite = new LinearLayoutManager(this);
        linearLayoutManagerSite.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManagerSite);
        adapter = new QualityFoodAdapter(R.layout.fp_item_quality_food, foodList);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int viewId = foodList.get(position).getFoodId();
                Intent intent = new Intent(QualityFoodActivity.this, QualityFoodDetailActivity.class);
                intent.putExtra("foodId", String.valueOf(viewId));
                startActivity(intent);
            }
        });

        HashMap<Object, Object> map = new HashMap<>();
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.getQualityFoodData(body).enqueue(new Callback<QualityFoodModel>() {
            @Override
            public void onResponse(Call<QualityFoodModel> call, Response<QualityFoodModel> response) {
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

            private void handleServerData(QualityFoodModel model) {
                List<QualityFoodModel.ListBean> list = model.getList();
                L.e("dataCount----" + list.size());
                foodList.clear();
                foodList.addAll(list);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<QualityFoodModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
