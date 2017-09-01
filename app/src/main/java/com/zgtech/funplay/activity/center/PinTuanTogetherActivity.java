package com.zgtech.funplay.activity.center;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.PinTuanTogetherAdapter;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.PinTuanTogetherModel;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PinTuanTogetherActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_right)
    ImageView ivRight;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    private PinTuanTogetherAdapter adapter;
    private List<PinTuanTogetherModel.ObjBean> originList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pintuan_together);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
        tvToolbar.setText("一起拼团");
        ivRight.setBackgroundResource(R.drawable.ic_add_white_24dp);
//        ivRight.setImageResource(R.drawable.icon_arrow_right);
    }

    private void initPinTuanTogether(List<PinTuanTogetherModel.ObjBean> originList) {
        adapter = new PinTuanTogetherAdapter(this, R.layout.fp_item_pintuan_together, originList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void initData() {
        mApiStores.getPinTuanTogetherData("0", "false").enqueue(new Callback<PinTuanTogetherModel>() {
            @Override
            public void onResponse(Call<PinTuanTogetherModel> call, Response<PinTuanTogetherModel> response) {
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

            private void handleServerData(PinTuanTogetherModel model) {
                originList = model.getObj();

                initPinTuanTogether(originList);
            }

            @Override
            public void onFailure(Call<PinTuanTogetherModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });


    }

    @OnClick({R.id.ll_back, R.id.tv_toolbar, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_toolbar:
                break;
            case R.id.iv_right:
                toNextActivity(PushNewOrderActivity.class);
                break;
        }
    }
}
