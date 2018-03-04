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
import com.zgtech.funplay.activity.CoreOrderDetailActivity;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.QualityScenicDetailModel;
import com.zgtech.funplay.model.QualityScenicModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.DateUtil;
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

public class QualityScenicDetailActivity extends BaseActivity {

    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.tv_scenic_detail_title)
    TextView tvTitle;
    @Bind(R.id.tv_scenic_detail_description)
    TextView tvDescription;
    @Bind(R.id.tv_scenic_detail_date)
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_scenic_detail);
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
            id = intent.getStringExtra("viewId");
        }
        mApiStores.getScenicDetailData(id).enqueue(new Callback<QualityScenicDetailModel>() {
            @Override
            public void onResponse(Call<QualityScenicDetailModel> call, Response<QualityScenicDetailModel> response) {
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

            private void handleServerData(QualityScenicDetailModel model) {
                tvTitle.setText(model.getObj().getName());
                tvDescription.setText(model.getObj().getDescript());
                tvDate.setText("时间：" + DateUtil.long2str(model.getObj().getCreateTime()));
            }

            @Override

            public void onFailure(Call<QualityScenicDetailModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
