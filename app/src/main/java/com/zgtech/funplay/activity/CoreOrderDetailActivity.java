package com.zgtech.funplay.activity;

import android.app.Activity;
import android.content.Intent;
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

import com.google.gson.Gson;
import com.pingplusplus.android.Pingpp;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.moduled.MyOrderActivity;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.model.ChargeModel;
import com.zgtech.funplay.model.OrderDetailModel;
import com.zgtech.funplay.utils.L;
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

public class CoreOrderDetailActivity extends BaseActivity {
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
        initPageData();
    }


    @OnClick({R.id.ll_back, R.id.btn_pin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.btn_pin:
                initPayModule();
                break;
        }
    }


    /**
     * 除QQ钱包外，其他渠道调起支付方式：
     * 参数一：Activity 表示当前调起支付的Activity
     * 参数二：data 表示获取到的charge或order的JSON字符串
     */
    private void initPayModule() {
        mApiStores.initCharge(orderId).enqueue(new Callback<ChargeModel>() {
            @Override
            public void onResponse(Call<ChargeModel> call, Response<ChargeModel> response) {
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

            private void handleServerData(ChargeModel body) {
                ChargeModel.ObjBean charge = body.getObj();
                Gson gson = new Gson();
                String chargeJson = gson.toJson(charge);
                Pingpp.createPayment(CoreOrderDetailActivity.this, chargeJson);
            }

            @Override
            public void onFailure(Call<ChargeModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //支付页面返回处理
        if (requestCode == Pingpp.REQUEST_CODE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getExtras().getString("pay_result");
            /* 处理返回值
             * "success" - 支付成功
             * "fail"    - 支付失败
             * "cancel"  - 取消支付
             * "invalid" - 支付插件未安装（一般是微信客户端未安装的情况）
             * "unknown" - app进程异常被杀死(一般是低内存状态下,app进程被杀死)
             */
                String errorMsg = data.getExtras().getString("error_msg"); // 错误信息
                String extraMsg = data.getExtras().getString("extra_msg"); // 错误信息
                L.i(result);
                L.i(errorMsg);
                L.i(extraMsg);


                if (result.toString().equals("success")) {
                    doPinTuan();
                } else if (result.toString().equals("cancel")) {
                    T.showShort("您取消了支付");
                } else if (result.toString().equals("fail")) {
                    T.showShort("支付失败！");
                } else if (result.toString().equals("invalid")) {
                    if (errorMsg.equals("wx_app_not_installed")) {
                        T.showShort("请您先安装微信！");
                    } else {
                        T.showShort("支付插件未安装");
                    }
                }

            }
        }
    }


    private void initPageData() {
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
        tvPrice.setText("￥" + individualModel.getOrderPrice1() + "");//0是旧价格，1是新价格
        tvPriceOld.setText("￥" + individualModel.getOrderPrice0() + "");
        tvPrice.getPaint().setFlags(Paint.FAKE_BOLD_TEXT_FLAG);
        tvPriceOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvTime.setText(individualModel.getOrderTime() + "");
        tvOrderTrip.setText(individualModel.getOrderTrip() + "");
        tvOrderRemark.setText(individualModel.getOrderRemark() + "");
        tvOrderAttention.setText(individualModel.getOrderAttention() + "");
        tvName.setText(individualModel.getOrderContact() + "");
        tvMobile.setText(individualModel.getOrderPhone() + "");

    }


    private void doPinTuan() {
        mApiStores.joinOrder(orderId).enqueue(new Callback<BaseResultModel>() {
            @Override
            public void onResponse(Call<BaseResultModel> call, Response<BaseResultModel> response) {
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

            private void handleServerData(BaseResultModel model) {
                finish();

                toNextActivity(MyOrderActivity.class);
                T.showShort("下单成功！");
            }

            @Override
            public void onFailure(Call<BaseResultModel> call, Throwable t) {

            }
        });
    }

    private void initStatusBarState() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
