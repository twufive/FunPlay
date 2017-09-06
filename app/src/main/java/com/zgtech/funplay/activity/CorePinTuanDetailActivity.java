package com.zgtech.funplay.activity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.OrderDetailModel;
import com.zgtech.funplay.utils.T;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 马上抢，进入后的  订单详情页面
 * Created by Administrator on 2017/8/14.
 */

public class CorePinTuanDetailActivity extends BaseActivity {
    @Bind(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_price)
    TextView tvPrice;
    @Bind(R.id.tv_price_old)
    TextView tvPriceOld;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_order_trip)
    TextView tvOrderTrip;
    @Bind(R.id.tv_order_remark)
    TextView tvOrderRemark;
    @Bind(R.id.tv_order_attention)
    TextView tvOrderAttention;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_mobile)
    TextView tvMobile;
    @Bind(R.id.btn_pin)
    Button btnPin;

    private String orderId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_pintuan_detail);
        ButterKnife.bind(this);

        orderId = getIntent().getExtras().getString("orderId", "");
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);

        initStatusBarState();
    }

    @Override
    public void initData() {
        mApiStores.getOrderDetailData(orderId).enqueue(new Callback<OrderDetailModel>() {
            @Override
            public void onResponse(Call<OrderDetailModel> call, Response<OrderDetailModel> response) {
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

            private void handleServerData(OrderDetailModel model) {
                OrderDetailModel.ObjBean individualModel = model.getObj();
                initElementView(individualModel);
            }

            @Override
            public void onFailure(Call<OrderDetailModel> call, Throwable t) {

            }
        });

    }

    private void initElementView(OrderDetailModel.ObjBean individualModel) {
        tvTitle.setText(individualModel.getOrderTitle() + "");
        tvPrice.setText("￥"+individualModel.getOrderPrice1() + "");//0是旧价格，1是新价格
        tvPriceOld.setText("￥"+individualModel.getOrderPrice0() + "");
        tvPrice.getPaint().setFlags(Paint.FAKE_BOLD_TEXT_FLAG);
        tvPriceOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvTime.setText(individualModel.getOrderTime() + "");
        tvOrderTrip.setText(individualModel.getOrderTrip() + "");
        tvOrderRemark.setText(individualModel.getOrderRemark() + "");
        tvOrderAttention.setText(individualModel.getOrderAttention() + "");
        tvName.setText(individualModel.getOrderContact() + "");
        tvMobile.setText(individualModel.getOrderPhone() + "");
    }


    private void initStatusBarState() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @OnClick({R.id.ll_back, R.id.btn_pin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.btn_pin:

                break;
        }
    }
}
