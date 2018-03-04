package com.zgtech.funplay.activity.modulea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.QualityFoodDetailModel;
import com.zgtech.funplay.utils.DateUtil;
import com.zgtech.funplay.utils.T;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QualityFoodDetailActivity extends BaseActivity {

    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.tv_food_detail_title)
    TextView tvTitle;
    @Bind(R.id.tv_food_detail_description)
    TextView tvDescription;
    @Bind(R.id.tv_food_detail_date)
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_food_detail);
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
        tvToolbar.setText("景点详情");
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String id = "1";
        if(intent != null){
            id = intent.getStringExtra("foodId");
        }
        mApiStores.getFoodDetailData(id).enqueue(new Callback<QualityFoodDetailModel>() {
            @Override
            public void onResponse(Call<QualityFoodDetailModel> call, Response<QualityFoodDetailModel> response) {
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

            private void handleServerData(QualityFoodDetailModel model) {
                tvTitle.setText(model.getObj().getName());
                tvDescription.setText(model.getObj().getDescript());
                tvDate.setText("时间：" + DateUtil.long2str(model.getObj().getCreateTime()));
            }

            @Override
            public void onFailure(Call<QualityFoodDetailModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
